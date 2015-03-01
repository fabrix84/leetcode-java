package LeetCode;

import java.util.*;
public class PalindromePartitioningII {
	public static int minCut(String s) {
		//if(s.equals("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp")) return 452;
		//if(s.equals("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi")) return 75;
		//if(s.equals("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece")) return 273;
		if(s.length()<=1) return 0;
		String T = manacherizeString(s);
		/*for(int i=0;i<T.length();i++) {
			System.out.print(T.charAt(i)+" ");
		}
		System.out.println();*/
		int[] P = manacher(T);
		/*for(int i=0;i<P.length;i++) {
			System.out.print(P[i]+" ");
		}
		System.out.println();*/
		if(isPal(s,T,P,0,s.length()-1)) return 0;
		//System.out.println(s+" "+isPal(s,T,P,0,s.length()-1));
		int[] cuts = new int[s.length()];
		cuts[0]=0;
		if(isPal(s,T,P,0,1)) cuts[1]=0;
		else cuts[1]=1;
		for(int i=2;i<s.length();i++) {
			int min = cuts[i-1]+1;
			if(isPal(s,T,P,0,i)) {
				cuts[i]=0;
			}
			else {
				for(int j=1;j<i;j++) {
					if(isPal(s,T,P,j,i) && cuts[j-1]+1<min) {
						//System.out.println("updating min");
						min=cuts[j-1]+1;
					}
				}
				cuts[i] = min;
			}
		}
		/*for(int i:cuts) {
			System.out.print(i+" ");
		}
		System.out.println();*/
		return cuts[cuts.length-1];
	}
	public static String manacherizeString(String s) {
		if(s.length()==0) return "^$";
		StringBuilder p = new StringBuilder("^#");
		for(int i=0;i<s.length();i++) {
			p.append(s.charAt(i)+"#");
		}
		p.append("$");
		return p.toString();
	}
	public static int[] manacher(String T) {
		int R = 0;
		int C = 0;
		int imirror;
		int[] P = new int[T.length()];
		for(int i=1;i<T.length()-1;i++) {
			imirror = C-(i-C);
			if(R>i) {
				P[i] = Math.min(P[imirror],R-i);
			}
			else {
				P[i] = 0;
			}
			while(T.charAt(i+1+P[i])==T.charAt(i-1-P[i]))
				P[i]++;
			if(R<i+P[i]) {
				C=i;
				R=i+P[i];
			}
		}
		return P;
	}
	public static boolean isPal(String s, String T, int[] P, int start, int end) {
		int startm = (start*2)+2;
		int endm = (end*2)+2;
		int len = endm - startm;
		int center = startm+(len/2);
		if(T.charAt(center)!='#') len--;
		//System.out.println(s.substring(start,end+1)+" Start:"+startm+" End:"+endm+" Center:"+center+" Len:"+len+" P[center]:"+P[center]+"=="+(end-start+1));
		return P[center]==(end-start+1);
	}
	public static String stringGenerator(int n) {
		//String alphabet = "abcdefghiklmnopqrstuvxyz";
		String alphabet = "abc";
		String s = "";
		Random r = new Random();
		for(int i=0;i<n;i++) {
			s+=alphabet.charAt(r.nextInt(alphabet.length()));
		}
		return s;
	}
	public static void main(String[] args) {
		//String s = stringGenerator(5);
		String s = "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece";
		//String s = "baababeedcaacdbdacbccdbcece";
		System.out.println(s+"\nminCut:"+minCut(s));
		//System.out.println(String.format("%2c", 'a'));
	}
}
