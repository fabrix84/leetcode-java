package LeetCode;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		if(A.length==0) return 1;
		for(int i=0;i<A.length;i++) {
			if(A[i]!=i+1) {
				while(A[i]>0 && A[i]-1<A.length && A[i]!=i+1 && A[A[i]-1]!=A[i]) {
					//System.out.println(A[i]+" "+A[A[i]-1]);
					int temp = A[A[i]-1];
					A[A[i]-1] = A[i];
					A[i] = temp;
				}
			}
		}
		int i=0;
		for(;i<A.length;i++) {
			if(A[i]!=i+1) return i+1;
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] a = {2,1};
		System.out.println(firstMissingPositive(a));
	}
}
