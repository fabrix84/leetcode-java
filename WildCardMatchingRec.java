package LeetCode;

public class WildCardMatchingRec {
	public static boolean isMatch(String s, String p) {
		p = remConsAst(p);
		return isMatchRec(s,p);
	}
	public static boolean isMatchRec(String s, String p) {
		//System.out.println("Matching "+s+" with "+p);
		if(s.length()<minToMatch(p)) return false;
		if(s.length()==0 && (p.length()==0 || onlyAst(p))) {
			return true;
		}
		else if(s.length()==0) {
			return false;
		}
		else if(p.length()==0){
			return false;
		}
		else {
			if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?') {
				return (isMatchRec(s.substring(1),p.substring(1)));
			}
			else if(p.charAt(0)=='*') {
				return (isMatchRec(s.substring(1),p.substring(1)) || isMatchRec(s.substring(1),p));
			}
			else {
				return false;
			}
		}
	}
	public static int minToMatch(String p) {
		int min = 0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)!='*') min++;
		}
		return min;
	}
	public static String remConsAst(String p) {
		StringBuilder r = new StringBuilder();
		char prev = ' ';
		char curr = ' ';
		for(int i=0;i<p.length();i++) {
			curr = p.charAt(i);
			if(curr=='*' && prev=='*') continue;
			r.append(curr);
			prev=curr;
		}
		return r.toString();
	}
	public static boolean onlyAst(String p) {
		return (p.length()==1 && p.charAt(0)=='*')?true:false;
	}
	public static void main(String[] args) {
		String s = "abbbaaaaaaaabbbabaaabbabbbaabaabbbbaabaabbabaabbabbaabbbaabaabbabaabaabbbbaabbbaabaaababbbbabaaababbaaa";
		String p = "ab**b*bb*ab**ab***b*abaa**b*a*aaa**bba*aa*a*abb*a*a";
		long startTime = System.currentTimeMillis();
		System.out.println("String: "+s+"\nPattern: "+p+"\nIsMatch: "+isMatch(s,p));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime+" ms");
	}
}
