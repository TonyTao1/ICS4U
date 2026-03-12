package balabalaba;

public class baard {
	public static void main(String[] args) {
		int[][] board = {{1,2,3,4},{2,3},{2,5,3,56}};
		for(int j = 0; j<board.length; j++) {
			if(j==1) {
				continue;
			}
			for(int i = 0; i < board[j].length; i++) {
				//System.out.print(board[j][i]);
			}
			//System.out.printf("%n");
		}
		int x = 8;
		;
		System.out.print(bilibili(x));
		
	}
	public static int bilibili(int x) {
		x = 10;
		return x;
	}

}
