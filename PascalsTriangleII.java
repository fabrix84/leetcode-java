package LeetCode;

import java.util.*;

public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		if(rowIndex==0) {return l;}
		for(int n=1;n<=rowIndex;n++) {
			l.add(1);
			for(int k=n-1;k>0;k--) {
				l.set(k,l.get(k)+l.get(k-1));
			}
		}
		return l;
	}
	public static void main(String[] args) {
		System.out.println(getRow(21));
	}
}
