package assignment1;

//2026.02.21 TonyTao Unit1Assignment PartC, find the largest sum of consecutive numbers in the list case by case
import java.io.*;
import java.util.Scanner;

public class Unit1AssignmentPartC {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input2.txt"));

		int caseNum = isValidCount(sc.next());
		if (caseNum == -1) {
			sc.close();
			return;
			// to test if the counting of the cases is valid
		}

		for (int i = 1; i <= caseNum; i++) {
			int arrLength = isValidCount(sc.next());
			boolean isValid = arrLength != -1;
			// to check if the length of the array is valid, for example "z" is not a valid
			// input

			if (!isValid && i < caseNum) {
				// if it is not valid then skip this one
				sc.nextLine();
				sc.nextLine();
			}

			if (isValid) {
				// if it is valid then continue
				int[] input = new int[arrLength];
				// convert the line into a new array
				for (int j = 0; j < input.length; j++) {
					try {
						int num = Integer.parseInt(sc.next());
						input[j] = num;
					} catch (NumberFormatException e) {
						// if the digit in this case is found to be invalid, then skip this one and
						// continue to the next case
						isValid = false;
						if (i < caseNum) {
							sc.nextLine();
						}
						break;
					}
				}
				if (isValid) {
					int max = findSum(input);
					System.out.println("Case #" + i + ": " + max);
				}
			}
		}
		sc.close();
	}

	public static int findSum(int[] numArray) {
		// to find the biggest sum of the number added together,
		// by using the method of adding Add the digits following this number, starting
		// with the next one, until all digits are added.
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < numArray.length; i++) {
			// find the starting digit
			int sum = 0;
			for (int j = i; j < numArray.length; j++) {
				// the digit after the starting digit been added together one by one
				sum += numArray[j];
				if (max < sum) {
					max = sum;
				}
			}
		}
		return max;
	}

	public static int isValidCount(String str) {
		// to test if the input is valid, same as boolean
		try {
			int count = Integer.parseInt(str);
			if (count > 0) {
				return count;
			} else {
				return -1;
				// If not valid then return -1
			}
		} catch (NumberFormatException e) {
			// If not valid then return -1
			return -1;
		}
	}
}
