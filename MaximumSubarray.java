package LeetCode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max=nums[0], sum=nums[0];
		for(int i=1;i<nums.length;i++) {
			sum = Math.max(sum+nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
	public int maxSubArrayDP(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1]+A[i] : A[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
