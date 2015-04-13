package LeetCode;

public class JumpGame {
	public static boolean canJump(int[] A) {
		if(A==null || A.length==0 || A.length<A[0]) return true;
		int maxreach = A[0];
		for(int i=0;i<A.length;i++) {
			if(i>maxreach) return false;
			maxreach=(maxreach>i+A[i])?maxreach:i+A[i];
		}
		return true;
	}
	public static void main(String[] args) {
		//int[] A = {2,3,1,1,4};
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}
}
