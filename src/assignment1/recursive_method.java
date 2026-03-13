package assignment1;

public class recursive_method {
	public static void main(String args[] ){
		
	}
	public static String rev(String input) {
		if(input.length() == 1) {
			return input;
		}
		return rev(input.substring(input.indexOf("")+1 ) + "," + input.substring(0, input.indexOf("")));
	}
}