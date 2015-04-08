package LeetCode;

import java.util.Random;

public class NumberofIslands {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	public static int numIslands(char[][] grid) {
		if(grid==null || grid.length==0) return 0;
		int islands = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]=='1') {
					explore(grid,i,j);
					islands++;
				}
			}
		}
		return islands;
	}
	public static void explore(char[][] grid, int i, int j) {
		grid[i][j]='x';
		for(int d=0;d<dx.length;d++) {
			if(i+dy[d]<grid.length && i+dy[d]>=0 && j+dx[d]<grid[0].length && j+dx[d]>=0 && grid[i+dy[d]][j+dx[d]]=='1') {
				explore(grid,i+dy[d],j+dx[d]);
			}
		}
	}
	public static void printGrid(char[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static char[][] genGrid(int m, int n) {
		Random r = new Random();
		char[][] grid = new char[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(r.nextInt(2)==1) {
					grid[i][j]='1';
				}
				else {
					grid[i][j]='0';
				}
			}
		}
		return grid;
	}
	public static void main(String[] args) {
		Random r = new Random();
		char[][] grid = genGrid(r.nextInt(6),r.nextInt(6));
		printGrid(grid);
		System.out.println(numIslands(grid)+" Islands");
		printGrid(grid);
	}
}
