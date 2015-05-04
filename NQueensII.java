package LeetCode;

public class NQueensII {
	public static int totalNQueens(int n) {
		int[][] board = new int[n][n]; 
		return nQueens(0,0,board);
	}
	public static int nQueens(int i,int j, int[][] board) {
		int solutions = 0;
		for(int jj=j;jj<board[i].length;jj++) {
			if(!checkMove(i,jj,board)) continue; // checks if is possible to place a Queen in i,j
			if(i==board.length-1) return 1; // if we can place a Queen at last row, this is a solution
			board[i][jj]=1; // try to place a Queen in i,j
			if(i+1<board.length) solutions+=nQueens(i+1,0,board); // go to next row, we can place just 1 Queen per row
			board[i][jj]=0; // Backtracking
		}
		return solutions;
	}
	public static boolean checkMove(int i, int j, int[][] board){
		// checkMove needs to check just in previous rows for Queens
		for(int ii=0;ii<i;ii++) {
			if(board[ii][j]==1) return false; // Checks for queens already placed in this col
		}
		int row;int col;
		row = i-1; col = j-1;
		while(row>=0 && col>=0) {
			if(board[row--][col--]==1) return false; // Checks for queens already placed in top-left -> bottom-right diagonal
		}
		row = i-1; col = j+1;
		while(row>=0 && col<board[row].length) {
			if(board[row--][col++]==1) return false; // Checks for queens already placed in top-right -> bottom-left diagonal
		}
		return true;
	}
	public static void printMatrix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(String.format("%2d ", m[i][j]));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		System.out.println(totalNQueens(4));
		int[][] board = {
						{1,0,0},
						{0,0,0},
						{0,0,0},
					};
		//System.out.println(checkMove(1,2,board));
	}
}
