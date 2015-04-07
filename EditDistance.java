package LeetCode;

import java.util.Arrays;

public class EditDistance {
	public static int minDistance(String word1, String word2) {
		int distance = 0;
		if(word1==null || word1.length()==0) return word2.length();
		if(word2==null || word2.length()==0) return word1.length();
		int[] prev = new int[word2.length()+1];
		int[] curr = new int[word2.length()+1];
		curr[0] = 0;
		for(int i=1;i<word2.length()+1;i++) {
			curr[i]=curr[i-1]+1;
		}
		for(int i=1;i<word1.length()+1;i++) {
			prev = Arrays.copyOf(curr, curr.length);
			curr[0] = i;
			for(int j=1;j<word2.length()+1;j++) {
				int costsubst = (word1.charAt(i-1)==word2.charAt(j-1))?prev[j-1]:prev[j-1]+1;
				curr[j] = Math.min(costsubst, Math.min(prev[j]+1, curr[j-1]+1));
			}
		}
		return curr[curr.length-1];
	}
	public static void printArray(int[] a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String S = "sea";
		String T = "eat";
		minDistance(S,T);
	}
}
