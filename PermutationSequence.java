package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		if(k==0 || n==0) return "";
		List<Integer> l = new ArrayList<Integer>();
		int[] facts = {1,1,2,6,24,120,720,5040,40320,362880};
		for(int i=1;i<=n;i++) {
			l.add(i);
		}
		StringBuffer perm = new StringBuffer();
		for(int i=0;i<n-1;i++) {
			int curr = l.remove(((k-1)/(facts[n-i-1]))%l.size());
			perm.append(curr);
		}
		perm.append(l.get(0));
		return perm.toString();
	}
	public static void main(String[] args) {
		System.out.println(getPermutation(3,3));
	}
}
