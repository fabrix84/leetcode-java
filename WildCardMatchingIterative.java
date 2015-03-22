package LeetCode;

public class WildCardMatchingIterative {
	public static boolean isMatch(String s, String p) {
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
		p = remConsAst(p);
		int pi = 0;
		int lastast = -1;
		int i = 0;
		int match = 0;
		while(i<s.length()) {
			if(pi<p.length() && (s.charAt(i)==p.charAt(pi)||p.charAt(pi)=='?')) {
				pi++;
				i++;
			}
			else if(pi<p.length() && p.charAt(pi)=='*') {
				lastast = pi;
				match = i;
				pi++;
			}
			else if(lastast!=-1) {
				pi = lastast;
				match++;
				i = match;
			}
			else {
				return false;
			}
		}
		while(pi<p.length() && p.charAt(pi)=='*') {
			pi++;
		}
		if(pi==p.length())
			return true;
		else
			return false;
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
	public static int minToMatch(String p) {
		int min = 0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)!='*') min++;
		}
		return min;
	}
	public static boolean onlyAst(String p) {
		return (p.length()==1 && p.charAt(0)=='*')?true:false;
	}
	public static void main(String[] args) {
		String s = "abefcdgiescdfimde";
		String p = "ab*cd?i*de";
		long startTime = System.currentTimeMillis();
		System.out.println("String: "+s+"\nPattern: "+p+"\nIsMatch: "+isMatch(s,p));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime+" ms");
	}
}
