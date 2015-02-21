package LeetCode;

import java.util.*;

public class MaximumProductSubarray {
	public static int maxProduct(int[] A) {
		int prevmax = A[0];
		int prevmin = A[0];
		int a,b;
		int max = A[0];
		for(int i=1;i<A.length;i++) {
			a = A[i]*prevmin;
			b = A[i]*prevmax;
			prevmax = Math.max(A[i], Math.max(a, b));
			prevmin = Math.min(A[i], Math.min(a, b));
			if(prevmax>max) {
				max = prevmax;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] A = {2,3,-2,4,6};
		int[] B = {};
		System.out.println(maxProduct(A));
	}
}
