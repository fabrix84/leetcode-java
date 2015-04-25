package LeetCode;

import java.util.Stack;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
		int maxarea = 0;
		int[][] m = new int[matrix.length+1][matrix[0].length+1];
		for(int i=0;i<matrix.length;i++) {
			for(int j=matrix[i].length-1;j>=0;j--) {
				m[i][j] = (matrix[i][j]=='0')?0:1+m[i][j+1];
			}
		}
		for(int i=0;i<m[0].length;i++){
            int p=0;
            Stack<Integer> s = new Stack<Integer>();
            while(p!=m.length){
                if(s.empty() || m[p][i]>=m[s.peek()][i])
                    s.push(p++);
                else{
                    int t = s.pop();
                    maxarea = Math.max(maxarea,m[t][i]*(s.empty()?p:p-s.peek()-1));
                }
            }
        }
		return maxarea;
	}
	public static void printMatrix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] matrix = {{'1'}};
		System.out.println(maximalRectangle(matrix));
	}
}
