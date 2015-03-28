package LeetCode;

public class BestTimeToBuyAndSellStockIII {
	public static int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
		//System.out.print("Stocks: ");
		//printArray(prices);
		int maxProfit = 0;
		int[] mpf = new int[prices.length];
		mpf[0] = 0;
		int min = prices[0];
		int[] mpb = new int[prices.length];
		for(int i=1;i<mpf.length;i++) {
			if(prices[i]<min) {
				min = prices[i];
				mpf[i] = mpf[i-1];
			}
			else {
				mpf[i] = Math.max(prices[i]-min,mpf[i-1]);
			}
		}
		//System.out.print("Mpf:    ");
		//printArray(mpf);
		mpb[mpb.length-1]=0;
		int max = prices[prices.length-1];
		int currentProfit = 0;
		for(int i=mpb.length-2;i>=0;i--) {
			if(prices[i]>max) {
				max = prices[i];
				mpb[i] = mpb[i+1];
			}
			else {
				mpb[i]=Math.max(max-prices[i],mpb[i+1]);
			}
			if(i>1) {
				currentProfit = mpb[i]+mpf[i-1];
			}
			else {
				currentProfit = mpb[i];
			}
			if(currentProfit>maxProfit) {
				maxProfit = currentProfit;
			}
		}
		//System.out.print("Mpb:    ");
		//printArray(mpb);
		return maxProfit;
	}
	public static void printArray(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(String.format("%2d", a[i])+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1,2,4}; 
		System.out.println(maxProfit(a));
	}
}
