package LeetCode;

import java.util.*;
public class MinimumWindowSubstring {
	public static String minWindow(String S, String T) {
		if(S.length()==0 || T.length()==0) return "";
		if(T.length()>S.length()) return "";
		String minS = "";
		Map<Character,Integer> ht = hashString(T);
		//System.out.println(ht);
		int start = -1;
		int end = 0;
		int minD = S.length();
		int count = 0;
		for(int i=0;i<S.length();i++) {
			char c = S.charAt(i);
			if(ht.containsKey(c) && count<T.length()) {
				//System.out.println("start "+start);
				int cc = ht.get(c);
				if(cc>0) count++;
				cc--;
				ht.put(c, cc);
				if(start==-1) start=i;
				end = i+1;
				if(count==T.length()) {
					char startc = S.charAt(start);
					while(!ht.containsKey(startc) || ht.get(startc)<0) {
						if(ht.containsKey(startc)) {
							int ccount = ht.get(startc);
							ccount++;
							ht.put(startc, ccount);
						}
						start++;
						startc = S.charAt(start);
					}
					minD=end-start;
					minS = S.substring(start,end);
					//System.out.println(ht);
					//System.out.println(minS);
				}
			}
			else if(ht.containsKey(c) && count>=T.length()){
				//System.out.println(c+" "+i);
				int ccount = ht.get(c);
				ccount--;
				ht.put(c, ccount);
				char startc = S.charAt(start);
				while(!ht.containsKey(startc) || ht.get(startc)<0) {
					//System.out.println(startc+" hash: "+ht.get(startc));
					if(ht.containsKey(startc)) {
						ccount = ht.get(startc);
						ccount++;
						ht.put(startc, ccount);
					}
					start++;
					startc = S.charAt(start);
				}
				end = i+1;
				//System.out.println("Start: "+start+" End: "+end+" Len: "+(end-start));
				if(end-start<minD) {
					minD = end-start;
					minS = S.substring(start,end);
					//System.out.println(minS);
				}
			}
		}
		//System.out.println(ht);
		return minS;
	}
	public static Map<Character,Integer> hashString(String T) {
		Map<Character,Integer> ht = new HashMap<Character,Integer>();
		for(char c: T.toCharArray()) {
			if(!ht.containsKey(c)) {
				ht.put(c, 1);
			}
			else {
				int count = ht.get(c);
				count++;
				ht.put(c, count);
			}
		}
		return ht;
	}
	public static void main(String[] args) {
		String S="bba";
		String T="ab";
		System.out.println("Result "+minWindow(S,T));
	}
}
