package balabalaba;

public class q4 {
	public static void main(String[] args) {
		String input = "abcdcbaa";
		System.out.println(palindrome(input));

	}
	public static boolean palindrome(String input) {
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(input.length() - i - 1) == input.charAt(i)) {
				if(i == (input.length()-2)/2) {
					return true;
				}
				continue;
			} else {
				return false;
			}
			

		}
		return true;
	}

}
