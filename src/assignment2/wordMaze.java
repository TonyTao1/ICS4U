package assignment2;

import java.io.*;
import java.util.Scanner;

/*
 * ICS4U1 Assignment #2 - Recursion: Word Maze
 *
 * Program goal:
 * Read multiple square letter grids and their target word lists from a file and solve each word list twice using recursive depth-first search (DFS):
 *   1) wordMaze1: path search, direction can change at every step.
 *   2) wordMaze2: line search, direction is fixed after the first move.
 * Recursion idea: Base case: stop when one letter remains and it matches and recursive case is to move to the next cell(s) and pass the rest of the word.
 */
public class wordMaze {

    // 8 directions: N, NE, E, SE, S, SW, W, NW
    public static int[] DR = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] DC = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
    	File testFile=new File("triangle.java");
        String inputFile;
        if (args.length > 0) {
            inputFile = args[0];
        } else {
            inputFile = "assignment2Input.txt";
        }

        char[][][] grids;
        String[][] wordsByGrid;
        Scanner sc = null;

        try {
            sc = new Scanner(new File(inputFile));
            int numberOfGrids = sc.nextInt();
            grids = new char[numberOfGrids][][];
            wordsByGrid = new String[numberOfGrids][];

            for (int g = 0; g < numberOfGrids; g++) {
                // Read the N x N grid.
                int size = sc.nextInt();
                char[][] grid = new char[size][size];
                for (int r = 0; r < size; r++) {
                    String row = readGridRow(sc, size);
                    for (int c = 0; c < size; c++) {
                        grid[r][c] = row.charAt(c);
                    }
                }
                grids[g] = grid;

                // Read the word list for this grid
                int wordCount = sc.nextInt();
                String[] words = new String[wordCount];
                for (int w = 0; w < wordCount; w++) {
                    words[w] = sc.next().toUpperCase();
                }
                wordsByGrid[g] = words;
            }
            sc.close();
        } catch (RuntimeException e) {

            sc.close();
            System.out.println("Input format error while reading: " + inputFile);
            return;
        }

        // --- wordMaze1 output ---
        System.out.println("wordMaze1 output:");
        System.out.println();
        for (int i = 0; i < grids.length; i++) {
            printGridSection(i + 1, grids[i]);
            String[] words = wordsByGrid[i];
            for (int w = 0; w < words.length; w++) {
                printResult(words[w], searchWordMaze1(grids[i], words[w]));
            }
            System.out.println();
        }

        // --- wordMaze2 output ---
        System.out.println("wordMaze2 output:");
        System.out.println();
        for (int i = 0; i < grids.length; i++) {
            printGridSection(i + 1, grids[i]);
            String[] words = wordsByGrid[i];
            for (int w = 0; w < words.length; w++) {
                printResult(words[w], searchWordMaze2(grids[i], words[w]));
            }
            System.out.println();
        }

        // --- wordMaze1Bonus output ---
        File wordListFile = new File("wordlist.txt");
        if (wordListFile.exists()) {
            String[] wordList = loadWordList("wordlist.txt");
            System.out.println("wordMaze1Bonus output:");
            System.out.println();
            for (int i = 0; i < grids.length; i++) {
                printGridSection(i + 1, grids[i]);
                wordMaze1Bonus(i + 1, grids[i], wordList);
                System.out.println();
            }
        } else {
            System.out.println("wordlist.txt not found.");
        }
    }

    // Prints one grid section exactly in assignment output style
    public static void printGridSection(int gridNumber, char[][] grid) {
        System.out.println("Grid #" + gridNumber + ":");
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Prints one word result line in the required "found / NOT found" format
    public static void printResult(String word, boolean found) {
        if (found) {
            System.out.println(word + " is found.");
        } else {
            System.out.println(word + " is NOT found.");
        }
    }

    /*
     * Reads one logical row of grid letters
     * It concatenates tokens until at least 'size' letters are available
     */
    public static String readGridRow(Scanner sc, int size) {
        StringBuilder row = new StringBuilder();

        while (row.length() < size && sc.hasNext()) {
            row.append(sc.next());
        }

        // Keep only the first 'size' letters in case extra separators/tokens were merged
        return row.substring(0, size);
    }

    /*
     * Part A wrapper
     * Tries every cell as a possible starting point for a DFS path
     */
    public static boolean searchWordMaze1(char[][] grid, String word) {
        // Empty word is trivially found.
        if (word.length() == 0) {
            return true;
        }

        int n = grid.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // Fresh visited matrix per start cell
                boolean[][] visited = new boolean[n][n];
                if (wordMaze1(grid, r, c, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Part A recursive DFS to test whether Can move to any of 8 neighbors and is able to change direction every step, cannot reuse a cell in the same word path
     */
    public static boolean wordMaze1(char[][] grid, int row, int col, String word, boolean[][] visited) {
        // Case 1: invalid coordinate.
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length) {
            return false;
        }

        // Case 2: no cell reuse in one DFS path
        if (visited[row][col]) {
            return false;
        }

        // Case 3: current letter must match first character of current substring
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        // Case 4: all letters matched (single letter left and matched now)
        if (word.length() <= 1) {
            return true;
        }

        // Mark this cell before exploring deeper
        visited[row][col] = true;
        String remaining = word.substring(1);

        // Case 5: try all 8 directions for the next letter
        for (int d = 0; d < 8; d++) {
            int nextRow = row + DR[d];
            int nextCol = col + DC[d];

            // If one branch succeeds, unmark and bubble success up
            if (wordMaze1(grid, nextRow, nextCol, remaining, visited)) {
                visited[row][col] = false;
                return true;
            }
        }

        // Backtrack: unmark before returning failure
        visited[row][col] = false;
        return false;
    }

    /*
     * Part B wrapper
     * Start can be any cell,but once a direction is selected,recursion keeps
     */
    public static boolean searchWordMaze2(char[][] grid, String word) {
        // Empty word is trivially found.
        if (word.length() == 0) {
            return true;
        }

        int n = grid.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != word.charAt(0)) {
                    continue;
                }

                // Single-letter word is found as soon as start letter matches
                if (word.length() == 1) {
                    return true;
                }

                // Try each fixed direction once
                for (int d = 0; d < 8; d++) {
                    if (wordMaze2(grid, r, c, word, DR[d], DC[d])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Part B recursive DFS:
     * Uses one fixed direction for the entire word
     * Moves to exactly one next cell each recursive cal
     */
    public static boolean wordMaze2(char[][] grid, int row, int col, String word, int dRow, int dCol) {
        // Case 1: stepped outside the grid
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length) {
            return false;
        }

        // Case 2: current cell does not match needed letter
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        // Case 3: this was the final letter and it matched
        if (word.length() == 1) {
            return true;
        }

        // Case 4: continue one step forward in the same direction
        return wordMaze2(grid, row + dRow, col + dCol, word.substring(1), dRow, dCol);
    }

    /*
     * Loads all words from the given file
     * Words are converted to UPPERCASE to match grid letters directly
     *
     * Note: Words of any length are included (including 1-2 letters)
     * The scoring method handles short words by returning 0 points
     */
    public static String[] loadWordList(String path) throws IOException {
        // First pass: count all non-empty words
        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        while (line != null) {
            if (line.trim().length() > 0) {
                count++;
            }
            line = br.readLine();
        }

        br.close();

        // Second pass: store all non-empty words in UPPERCASE
        String[] wordList = new String[count];
        int index = 0;

        br = new BufferedReader(new FileReader(path));
        line = br.readLine();
        while (line != null) {
            String word = line.trim();
            if (word.length() > 0) {
                wordList[index] = word.toUpperCase();
                index++;
            }
            line = br.readLine();
        }

        br.close();
        return wordList;
    }

    /*
     * Iterates every dictionary word against the given grid using the bonus
     * path search, prints each found word with its point value, and prints
     * the total score for this grid at the end
     */
    public static int wordMaze1Bonus(int gridNumber, char[][] grid, String[] wordList) {
        int totalScore = 0;

        for (int w = 0; w < wordList.length; w++) {
            String word = wordList[w];

            // Reuse the original Part A wrapper/path search
            if (searchWordMaze1(grid, word)) {
                int points = scoreWord(word);
                // System.out.println(word.toLowerCase() + " (+" + points + ")"); // Print found word in lowercase with points
                totalScore += points;
            }
        }

        System.out.println("Score for Grid #" + gridNumber + ": " + totalScore);
        return totalScore;
    }

    /*
     * Returns the point value for a word based on its length
     */
    public static int scoreWord(String word) {
        int len = word.length();

        if (len < 3) {
            return 0;
        }

        if (len <= 4) {
            return 1;
        }
        if (len == 5) {
            return 2;
        }
        if (len == 6) {
            return 3;
        }
        if (len == 7) {
            return 5;
        }

        // 8 or more letters
        return 11;
    }
}
