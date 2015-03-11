package LeetCode;

import java.util.*;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix.length==0 || matrix==null) return new ArrayList<Integer>();
		List<Integer> l = new ArrayList<Integer>();
		int count = 0;
		int total = matrix.length*matrix[0].length;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int i=0;
		int j=-1;;
		while(count < total) {
			j++;
			while(j<matrix[0].length && !visited[i][j]) {
				visited[i][j]=true;
				l.add(matrix[i][j]);
				count++;
				j++;
			}
			j--;
			i++;
			while(i<matrix.length && !visited[i][j]) {
				visited[i][j]=true;
				l.add(matrix[i][j]);
				count++;
				i++;
			}
			i--;
			j--;
			while(j>=0 && !visited[i][j]) {
				visited[i][j]=true;
				l.add(matrix[i][j]);
				count++;
				j--;
			}
			j++;
			i--;
			while(i>=0 && !visited[i][j]) {
				visited[i][j]=true;
				l.add(matrix[i][j]);
				count++;
				i--;
			}
			i++;
		}
		return l;
	}
	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 3, 4, 5},
						  { 6, 7, 8, 9,10},
						  {11,12,13,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,25}
						 };
		System.out.println(spiralOrder(matrix));
	}
}
