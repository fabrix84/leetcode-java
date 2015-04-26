package LeetCode;

import java.util.Arrays;

public class MaximumGap {
	public int maximumGap(int[] num) {
		if(num==null || num.length<2)
			return 0;
		int min = num[0];
		int max = num[0];
		for(int i: num) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int gap = (int) Math.ceil((double) (max-min)/(num.length-1));
		int[] mins = new int[num.length-1];
		int[] maxs = new int[num.length-1];
		Arrays.fill(mins, Integer.MAX_VALUE);
		Arrays.fill(maxs, Integer.MIN_VALUE);
		for(int n: num) {
			if(n==max || n==min) continue;
			int bucket = (n-min)/gap;
			mins[bucket] = Math.min(n, mins[bucket]);
			maxs[bucket] = Math.max(n, maxs[bucket]);
		}
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for(int i=0;i<mins.length-1;i++) {
			if(mins[i]==Integer.MAX_VALUE && maxs[i]==Integer.MIN_VALUE)
				continue;
			maxGap = Math.max(maxGap, mins[i]-previous);
			previous = maxs[i];
		}
		maxGap = Math.max(maxGap, max-previous);
		return maxGap;
	}
}
