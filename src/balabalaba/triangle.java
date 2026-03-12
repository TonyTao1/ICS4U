package balabalaba;
import java.util.Scanner;
public class triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		boolean result = isTriangleular(x);
		System.out.println(result);
		
	}
	public static boolean isTriangleular(int x) {
		for(int i=1; x >0; i++) {
			x = x - i;
		}
		return x == 0;
	}

}
