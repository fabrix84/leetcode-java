package LeetCode;

public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if(k>len/2) {
			int max = 0;
			for(int i=1;i<len;i++) {
				if(prices[i]>prices[i-1]) {
					max = max + prices[i] - prices[i-1];
				}
			}
			return max;
		}
		else {
			int[][] ts = new int[k+1][len];
			for(int i=1;i<=k;i++) {
				int currMax = ts[i-1][0]-prices[0];
				for(int j=1;j<len;j++) {
					ts[i][j] = Math.max(ts[i][j-1],currMax+prices[j]);
					currMax = Math.max(currMax, ts[i-1][j-1]-prices[j]);
				}
			}
			return ts[k][len-1];
		}
	}
}
