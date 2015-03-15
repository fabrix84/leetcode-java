package LeetCode;

import java.util.*;

class Pos {
	int i;
	int j;
	public Pos() {};
	public Pos(int i, int j) {
		this.i=i;
		this.j=j;
	}
	public String toString() {
		return "("+this.i+","+this.j+")";
	}
}
public class SurroundedRegions {
	public static void solve(char[][] board) {
		if(board==null || board.length<3 || board[0].length<3) return;
		boolean[][] passed = new boolean[board.length][board[0].length];
		for(int i=1;i<board.length-1;i++) {
			for(int j=1;j<board[i].length-1;j++) {
				if(board[i][j]=='O' && !passed[i][j]) {
					passed[i][j] = true;
					bfs(board, i, j,passed);
				}
			}
		}
	}
	public static void bfs(char[][] board, int i, int j,boolean[][] passed) {
		List<Pos> toflip = new ArrayList<Pos>();
		List<Pos> tovisit = new ArrayList<Pos>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		Pos visiting = new Pos(i,j);
		tovisit.add(visiting);
		while(tovisit.size()>0) {
			visiting = tovisit.remove(0);
			if(!visited[visiting.i][visiting.j]) {
				visited[visiting.i][visiting.j]=true;
				passed[visiting.i][visiting.j]=true;
				if(visiting.i==0 || visiting.i==board.length-1 || visiting.j==0 || visiting.j==board[visiting.i].length-1) return;
				toflip.add(visiting);
				List<Pos> moves = possMoves(visiting,board,visited);
				for(Pos p: moves) {
					tovisit.add(p);
				}
			}
		}
		//System.out.println(toflip);
		for(Pos p: toflip) {
			board[p.i][p.j]='X';
		}
		return;
	}
	public static List<Pos> possMoves(Pos p, char[][] board, boolean[][] visited) {
		List<Pos> moves = new ArrayList<Pos>();
		int[] di = {-1,0,0,1};
		int[] dj = {0,-1,1,0};
		for(int i = 0;i<di.length;i++) {
			if(p.i+di[i]>=0 && p.i+di[i]<board.length && p.j+dj[i]>=0 && p.j+dj[i]<board[p.i+di[i]].length 
					&& board[p.i+di[i]][p.j+dj[i]]=='O' && !visited[p.i+di[i]][p.j+dj[i]]) {
				moves.add(new Pos(p.i+di[i],p.j+dj[i]));
			}
		}
		return moves;
	}
	public static char[][] genBoard(int i, int j) {
		char[][] board = new char[i][j];
		Random r = new Random();
		for(int ii=0;ii<i;ii++) {
			for(int jj=0;jj<j;jj++) {
				if(r.nextInt(2)==1) {
					board[ii][jj]='O';
				}
				else {
					board[ii][jj]='X';
				}
			}
		}
		return board;
	}
	public static void printBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			System.out.print("[");
			for(int j=0;j<board[i].length-1;j++) {
				System.out.print(board[i][j]+",");
			}
			System.out.println(board[i][board[i].length-1]+"]");
		}
	}
	public static void main(String[] args) {
		//char[][] board = genBoard(4,5);
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		/*char[][] board = {{'O','X','O','O','O','O','O','O','O'},
						  {'O','O','O','X','O','O','O','O','X'},
						  {'O','X','O','X','O','O','O','O','X'},
						  {'O','O','O','O','X','O','O','O','O'},
						  {'X','O','O','O','O','O','O','O','X'},
						  {'X','X','O','O','X','O','X','O','X'},
						  {'O','O','O','X','O','O','O','O','O'},
						  {'O','O','O','X','O','O','O','O','O'},
						  {'O','O','O','O','O','X','X','O','O'}};*/
		printBoard(board);
		solve(board);
		System.out.println("Solved:");
		printBoard(board);
	}
}
