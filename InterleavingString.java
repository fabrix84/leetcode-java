package LeetCode;

public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		int[][] cache = new int[s1.length()+1][s2.length()+1];
		return (s1.length()+s2.length()!=s3.length())? false : isIntRec(s1,0,s2,0,s3,cache);
	}
	public static boolean isIntRec(String s1, int i1, String s2, int i2, String s3, int[][] cache) {
		if(cache[i1][i2]==1) return true;
		if(cache[i1][i2]==2) return false;
		//System.out.println(i1+","+i2);
		if(i1<s1.length() && s1.charAt(i1)!=s3.charAt(i1+i2) && 
				i2<s2.length() && s2.charAt(i2)!=s3.charAt(i1+i2)) {
			cache[i1][i2]=2;
			return false;
		}
		else if((i1<s1.length() && s1.charAt(i1)==s3.charAt(i1+i2)) && (i2<s2.length() && s2.charAt(i2)==s3.charAt(i1+i2))) {
			cache[i1][i2] = (isIntRec(s1,i1+1,s2,i2,s3,cache) || isIntRec(s1,i1,s2,i2+1,s3,cache))? 1 : 2;
			if(cache[i1][i2]==1) 
				return true;
			else
				return false;
		}
		else if(i1<s1.length() && s1.charAt(i1)==s3.charAt(i1+i2)) {
			cache[i1][i2] = isIntRec(s1,i1+1,s2,i2,s3,cache)?1:2;
			if(cache[i1][i2]==1) 
				return true;
			else
				return false;
		}
		else if(i2<s2.length() && s2.charAt(i2)==s3.charAt(i1+i2)) {
			cache[i1][i2] = isIntRec(s1,i1,s2,i2+1,s3,cache)?1:2;
			if(cache[i1][i2]==1) 
				return true;
			else
				return false;
		}
		else if(i1==s1.length() && i2==s2.length()) {
			return true;
		}
		else {
			cache[i1][i2]=2;
			return false;
		}
	}
	public static void main(String[] args) {
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(s1+"\n"+s2+"\n"+s3+"\n"+isInterleave(s1,s2,s3));
	}
}
