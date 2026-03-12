package balabalaba;
import java.io.*;
import java.util.Scanner;
public class rtyuj {
	public static void main(String[] args) {
		String abc = "12345678";
		q3(abc);
	}
	public static void q3(String input) {
		
		if((input.length())%2 == 0) {
			for(int i = 0; i<input.length(); i+=2) {
				System.out.print(input.charAt(i));
			}
		}
		else {
			for(int i = 1; i<input.length(); i+=2) {
				System.out.print(input.charAt(i));
			}
		}
	}

}
