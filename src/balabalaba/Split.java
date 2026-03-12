package balabalaba;
import java.util.*;
public class Split {
	public static void main(String[] args) {
		String line = "To be or not to be, that is the question.";
		StringTokenizer tokens;
		tokens = new StringTokenizer(line, ".!? ,");
		int max  = 0;
		while(tokens.hasMoreTokens()) {
			int wordLength = tokens.nextToken().length();
			if(wordLength > max) {
				max = wordLength;
			}
		}
		System.out.println(max);

	}

}
