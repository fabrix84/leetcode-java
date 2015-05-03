package LeetCode;

import java.util.*;

public class NQueens {
	public static  List<String[]> solveNQueens(int n) {
		List<String[]> solutions = new ArrayList<String[]>();
		if(n==0) return solutions;
		int[][] board = new int[n][n];
		String[] lines = new String[n];
		for(int i=0;i<n;i++) {
			StringBuffer line = new StringBuffer();
			for(int j=0;j<n;j++) {
				if(j==i) {
					line.append('Q');
				}
				else {
					line.append('.');
				}
			}
			lines[i]=line.toString();
		}
		solve(0,board,new String[n], n, solutions, lines);
		return solutions;
	}
	public static void solve(int i,int[][] board, String[] currsol, int n, List<String[]> solutions, String[] lines) {
		for(int j=0;j<n;j++) {
			if(board[i][j]==0) {
				//System.out.println("Placing queen in ("+i+","+j+")");
				String line = lines[j];
				currsol[i]=line;
				if(i==n-1) {
					//System.out.println("Adding solution");
					//for(String s: currsol) {
						//System.out.println(s);
					//}
					solutions.add(Arrays.copyOf(currsol, currsol.length));
					return;
				}
				setAttackedPositions(i,j,board);
				//printBoard(board);
				solve(i+1,board,currsol,n,solutions,lines);
				//System.out.println("Backtracking queen in ("+i+","+j+")");
				unsetAttackedPositions(i,j,board);
				//printBoard(board);
			}
		}
	}
	public static void setAttackedPositions(int i, int j, int[][] board) {
		board[i][j]++;
		for(int k=0;k<board[i].length;k++) {
			if(k!=j) board[i][k]++;
		}
		for(int k=0;k<board.length;k++) {
			if(k!=i) board[k][j]++;
		}
		int k = i;
		int z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]++;
			k++;
			z++;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]++;
			k++;
			z--;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]++;
			k--;
			z++;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]++;
			k--;
			z--;
		}
	}
	public static void unsetAttackedPositions(int i, int j, int[][] board) {
		board[i][j]--;
		for(int k=0;k<board[i].length;k++) {
			if(k!=j) board[i][k]--;
		}
		for(int k=0;k<board.length;k++) {
			if(k!=i) board[k][j]--;
		}
		int k = i;
		int z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]--;
			k++;
			z++;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]--;
			k++;
			z--;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]--;
			k--;
			z++;
		}
		k = i;
		z = j;
		while(k>=0 && k<board.length && z>=0 && z<board[k].length) {
			if(k!=i || z!=j) board[k][z]--;
			k--;
			z--;
		}
	}
	public static void printBoard(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int n = 4;
		for(String[] sol: solveNQueens(n)) {
			for(int i=0;i<sol.length;i++) {
				System.out.println(sol[i]);
			}
			System.out.println();
		}
		/*
		int[][] board = new int[n][n];
		setAttackedPositions(0,2,board);
		printBoard(board);
		unsetAttackedPositions(0,2,board);
		printBoard(board);
		*/
	}
}
