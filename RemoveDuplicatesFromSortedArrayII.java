package LeetCode;

public class RemoveDuplicatesFromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		int newi=0;
		int i=0;
		int count=0;
		while(i<A.length) {
			int curr = A[i];
			A[newi]=curr;
			count++;
			newi++;
			i++;
			if(i<A.length-1) {
				if(A[i]==A[i-1]) {
					A[newi]=A[i];
					count++;
					newi++;
					while(i<A.length && A[i]==A[i-1]) {
						i++;
					}
				}
			}
		}
		return count;
	}
	public static void printArray(int[] a) {
		for(int j=0;j<a.length;j++) {
			System.out.print(String.format(" %2d",a[j]));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};
		printArray(a);
		System.out.println(removeDuplicates(a));
		printArray(a);
	}
}
