package balabalaba;
import java.util.Scanner;
public class cccc {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int a  = sc.nextInt();
		int b  = sc.nextInt();
		int[][]x = new int[a][b];	
		for(int i = 0; i < x.length - 1; i++) {
			for(int j = 0; j < x[i].length-1; j++) {
				System.out.print(j + "");
		    }
			System.out.print(x[i][x[i].length - 1]);
			System.out.println();			
	    }

    }
}
