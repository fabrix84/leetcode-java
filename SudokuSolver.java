package LeetCode;

import java.io.IOException;
import java.util.*;

public class SudokuSolver {
	public static void solveSudoku(char[][] board) {
		Map<Integer,Set<Character>> lines = new HashMap<Integer,Set<Character>>();
		Map<Integer,Set<Character>> columns = new HashMap<Integer,Set<Character>>();
		Map<Integer,Set<Character>> boxes = new HashMap<Integer,Set<Character>>();
		int count = initCache(board,lines,columns,boxes);
		int tot = board.length*board[0].length;
		if(solver(board,0,-1,lines,columns,boxes,count,tot)!=tot) {
			System.out.println("no possible solutions");
		}
		else {
			printBoard(board);
		}
	}
	public static int solver(char[][] board, int i, int j, Map<Integer,Set<Character>> lines, Map<Integer,Set<Character>> columns, Map<Integer,Set<Character>> boxes, int count, int tot) {
		if(count==tot) return count;
		//printBoard(board);
		// get next element in board line by line
		if(j+1<board[i].length) {
			j++;
		}
		else {
			if(i+1<board.length) {
				i++;
				j=0;
			}
			else {
				return count;
			}
		}
		//check remaining lines
		if(board[i][j]=='.') {
			printBoard(board);
			System.out.println("-----------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Set<Character> moves = possMoves(board,i,j,lines,columns,boxes);
			if(moves.size()==0) {
				//System.out.println("No poss moves for "+i+","+j);
				return count;
			}
			for(Character c: moves) {
				//System.out.println("trying to set "+i+","+j+" to "+c);
				board[i][j] = c;
				lines.get(i).add(c);
				columns.get(j).add(c);
				boxes.get((3*(i/3)+(j/3))).add(c);
				count++;
				if(solver(board,i,j,lines,columns,boxes,count,tot)==tot) {
					return tot;
				}
				//System.out.println("Backtracking "+i+","+j);
				lines.get(i).remove(c);
				columns.get(j).remove(c);
				boxes.get((3*(i/3)+(j/3))).remove(c);
				board[i][j] = '.';
				count--;
				printBoard(board);
				System.out.println("-----------------");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			//System.out.println(i+","+j+" already set to "+board[i][j]+" count:"+count);
			return solver(board,i,j,lines,columns,boxes,count,tot);
		}
		return count;
	}
	public static Set<Character> possMoves(char[][] board,int i,int j, Map<Integer,Set<Character>> lines, Map<Integer,Set<Character>> columns, Map<Integer,Set<Character>> boxes) {
		char[] numbers = {'1','2','3','4','5','6','7','8','9'};
		Set<Character> moves = new HashSet<Character>();
		for(char c: numbers) {
			if(!lines.get(i).contains(c) && !columns.get(j).contains(c) && !boxes.get((3*(i/3)+(j/3))).contains(c)) {
				moves.add(c);
			}
		}
		return moves;
	}
	public static int initCache(char[][] board, Map<Integer,Set<Character>> lines, Map<Integer,Set<Character>> columns, Map<Integer,Set<Character>> boxes) {
		for(int k=0;k<9;k++) {
			lines.put(k, new HashSet<Character>());
			columns.put(k, new HashSet<Character>());
			boxes.put(k, new HashSet<Character>());
		}
		int count = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]!='.') {
					lines.get(i).add(board[i][j]);
					columns.get(j).add(board[i][j]);
					boxes.get((3*(i/3)+(j/3))).add(board[i][j]);
					count++;
				}
			}
		}
		return count;
	}
	public static void printBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]='.';
			}
		}
		board[0][0]='5';
		board[0][1]='3';
		board[0][4]='7';
		board[1][0]='6';
		board[1][3]='1';
		board[1][4]='9';
		board[1][5]='5';
		board[2][1]='9';
		board[2][2]='8';
		board[2][7]='6';
		board[3][0]='8';
		board[3][4]='6';
		board[3][8]='3';
		board[4][0]='4';
		board[4][3]='8';
		board[4][5]='3';
		board[4][8]='1';
		board[5][0]='7';
		board[5][4]='2';
		board[5][8]='6';
		board[6][1]='6';
		board[6][6]='2';
		board[6][7]='8';
		board[7][3]='4';
		board[7][4]='1';
		board[7][5]='9';
		board[7][8]='5';
		board[8][4]='8';
		board[8][7]='7';
		board[8][8]='9';
		printBoard(board);
		solveSudoku(board);
		System.out.println("-----------------");
		printBoard(board);
	}
}
