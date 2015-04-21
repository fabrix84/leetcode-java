package LeetCode;

import java.util.Hashtable;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0) return 0;
		if(s.length()==1) return 1;
		int max = 1;
		int start = 0;
		int end = 1;
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		for(char c: s.toCharArray()) {
			if(ht.containsKey(c)) {
				if(ht.get(c)>0) {
					while(s.charAt(start)!=c) {
						ht.put(s.charAt(start), 0);
						start++;
					}
					start++;
				}
				else {
					ht.put(c, 1);
				}
			}
			else {
				ht.put(c, 1);
			}
			if(end-start>max) {
				max = end-start;
			}
			end++;
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("ashjgdsjkajdhsgaghj"));
	}
}
