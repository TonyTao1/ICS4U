package balabalaba;
import java.util.Scanner;
public class scorelll {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(oneTwo(input));
	}
	public static String oneTwo(String str) {
		String stringBuilder = "";
		while(str.length() >= 3) {
			stringBuilder += "" + str.charAt(1) + str.charAt(2) + str.charAt(0);
			str = str.substring(3);
		}
		return stringBuilder + str;
	}

}
