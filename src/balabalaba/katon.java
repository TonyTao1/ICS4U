package balabalaba;
import java.util.Scanner;
public class katon {
	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String k = sc.nextLine();
	    System.out.println(removeWord(s, k));
	}
	
	public static String removeWord(String sentence, String word) {

	    int index = sentence.toLowerCase().indexOf(word.toLowerCase());

	    while (index > -1) {
	        sentence =
	            sentence.substring(0, index) +
	            sentence.substring(index + word.length());

	        index = sentence.toLowerCase().indexOf(word.toLowerCase());
	    }

	    return sentence;
	}

}
