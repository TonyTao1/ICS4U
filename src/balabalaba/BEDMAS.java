package balabalaba;
import java.util.*;
import java.util.StringTokenizer;
public class BEDMAS {
	public static void main(String[] args) {
		String line = "2+3+4";
		StringTokenizer tokens;
		tokens  = new StringTokenizer(line, "+-*/%", true);
		String previous = tokens.nextToken();
		int result = Integer.parseInt(previous);
		while(tokens.hasMoreTokens()) {
			if(tokens.nextToken().equals("+")) {
				result += Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(result);

	}
}
