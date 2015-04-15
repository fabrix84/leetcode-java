package LeetCode;

import java.util.*;

public class JumpGameII {
	public static int jump(int[] A) {
		if(A.length<=1) return 0;
		int maxReach = 0;
		int jumps = 0;
		int i = 0;
		while(i<A.length) {
			if(i+A[i]>maxReach) maxReach=i+A[i];
			jumps++;
			if(maxReach>=A.length-1) return jumps;
			int newMaxReach = maxReach;
			for(int j=i+1;j<=maxReach;j++) {
				if(j+A[j]>newMaxReach) {
					newMaxReach = j+A[j];
					i=j;
				}
			}
			maxReach = newMaxReach;
		}
		return jumps;
	}
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4,1,2,3,1,1,1};
		System.out.println(jump(A));
	}
}
