package LeetCode;

public class LongestPalindromicSubstring {
	public static String manacherize(String s) {
		StringBuilder ms = new StringBuilder("^");
		for(int i=0;i<s.length();i++) {
			ms.append("#"+s.charAt(i));
		}
		ms.append("#$");
		return ms.toString();
	}
	public static String longestPalindrome(String s) {
		if(s.length()==0) return "";
		String T = manacherize(s);
		int[] P = new int[T.length()];
		int C = 0;
		int R = 0;
		for(int i=1;i<T.length()-1;i++) {
			int imirror = C-(i-C);
			P[i] = (R > i) ? Math.min(R-i, P[imirror]) : 0;
			while(T.charAt(i+1+P[i])==T.charAt(i-1-P[i])) {
				P[i]++;
			}
			if(i+P[i]>R) {
				C = i;
				R = i + P[i];
			}
		}
		int maxLen = 0;
		int maxCenter = 0;
		for(int i=1;i<P.length-1;i++) {
			if(P[i]>maxLen) {
				maxLen = P[i];
				maxCenter = i;
			}
		}
		int start = (maxCenter-1-maxLen)/2;
		return s.substring(start,start+maxLen);
	}
	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		//System.out.println(manacherize(s));
		System.out.println(longestPalindrome(s));
	}
}
