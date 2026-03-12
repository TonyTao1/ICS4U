package balabalaba;
import java.math.BigInteger;

public class kkk {
	public static void main(String[] args) {
		System.out.println(fact(5));
	}
	public static String backStars (String word) {
		if (word.length() == 1) {
	        return word;
	    }
	    return word.charAt(word.length() - 1) + "*" + backStars(word.substring(0, word.length() - 1));
	}
	
	public static int fact(int n) {
		if(n == 1)
			return 1;
		return n * fact(n-1);
	}

}
