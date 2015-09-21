package LeetCode;

import java.util.Arrays;

public class HouseRobberII {
	public int subRob(int[] num) {
		num[num.length-1]=num[num.length-1];
		num[num.length-2]=Math.max(num[num.length-2],num[num.length-1]);
		for(int i=num.length-3;i>=0;i--) num[i] = Math.max(num[i]+num[i+2], num[i+1]);
		return num[0];
	}
	public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0], nums[1]);
		return Math.max(subRob(Arrays.copyOfRange(nums, 0, nums.length-1)), subRob(Arrays.copyOfRange(nums, 1, nums.length)));
	}
}
