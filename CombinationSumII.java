package LeetCode;

import java.util.*;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num==null || num.length==0) return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		if(num[0]>target) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		sumToTarget(num,target,lists,l,0);
		return lists;
	}
	public static void sumToTarget(int[] nums, int target, List<List<Integer>> lists, List<Integer> l, int index) {
		if(target<0) {
			return;
		}
		else {
			if(target==0) {
				lists.add(new ArrayList<Integer>(l));
			}
			else {
				int pre = -1;
				for(int i=index;i<nums.length;i++) {
					if(pre!=nums[i]) {
						l.add(nums[i]);
						sumToTarget(nums,target-nums[i],lists,l,i+1);
						l.remove(new Integer(nums[i]));
					}
					pre=nums[i];
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] set = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(set,target));
	}
}
