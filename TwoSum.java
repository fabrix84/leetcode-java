package LeetCode;

import java.util.*;
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> ht = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++) {
			if(ht.containsKey(target-numbers[i])) {
				result[0]=ht.get(target-numbers[i]);
				result[1]=i+1;
			}
			ht.put(numbers[i], i+1);
		}
		return result;
	}
}
