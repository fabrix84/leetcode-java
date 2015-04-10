package LeetCode;

public class HouseRobber {
	public static int rob(int[] num) {
		if(num==null || num.length==0) return 0;
		if(num.length==1) return num[0];
		if(num.length==2) return Math.max(num[0], num[1]);
		num[num.length-1]=num[num.length-1];
		num[num.length-2]=Math.max(num[num.length-2],num[num.length-1]);
		for(int i=num.length-3;i>=0;i--) {
			num[i] = Math.max(num[i]+num[i+2], num[i+1]);
		}
		return num[0];
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,1,9,2,2,10};
		System.out.println(rob(num));
	}
}
