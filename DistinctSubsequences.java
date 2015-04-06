package LeetCode;

public class DistinctSubsequences {
	public static int numDistinct(String S, String T) {
		if(S.length()<T.length()) return 0;
		int subs = 0;
		int[][] cache = new int[S.length()+1][T.length()+1];
		for(int i=0;i<cache.length;i++) {
			for(int j=0;j<cache[i].length;j++) {
				cache[i][j]=-1;
			}
		}
		subs = countSubs(S,0,T,0,cache);
		return subs;
	}
	public static int countSubs(String S, int i, String T, int j, int[][] cache) {
		if(cache[i][j]>=0) return cache[i][j];
		if(j==T.length()) {
			cache[i][j] = 1;
		}
		else if(i==S.length()) {
			cache[i][j] = 0;
		}
		else {
			if(S.charAt(i)!=T.charAt(j)) {
				while(i<S.length() && S.charAt(i)!=T.charAt(j)) i++;
				cache[i][j] = countSubs(S,i,T,j,cache);
			}
			else {
				cache[i][j] = countSubs(S,i+1,T,j,cache) + countSubs(S,i+1,T,j+1,cache);
			}
		}
		return cache[i][j];
	}
	public static void main(String[] args) {
		String S = "ABCDE";
		String T = "ACE";
		System.out.println(numDistinct(S,T));
	}
}
