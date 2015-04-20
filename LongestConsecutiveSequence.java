package LeetCode;

import java.util.*;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
		if(num==null || num.length==0) return 0;
		Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int max = 1;
		int lb, rb, len;
		for(int i:num) {
			if(hash.containsKey(i)) continue;
			lb = (hash.containsKey(i-1))? i - hash.get(i-1):i;
			rb = (hash.containsKey(i+1))? i + hash.get(i+1):i;
			len = (rb-lb)+1;
			if(len>max) max = len;
			hash.put(i, len);
			hash.put(lb, len);
			hash.put(rb, len);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] num = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		System.out.println(longestConsecutive(num));
	}
}
