package LeetCode;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		int sign = 1;
		long num = Math.abs((long) dividend);
		long den = Math.abs((long) divisor);
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
			sign = -1;
		}
		if(num==den) return sign;
		long res = 0;
		while(num>=den) {
			long count = 0;
			while(num>=(den<<count)) {
				count++;
			}
			res = res + ((long)1<<(count-1));
			num = num - (den<<(count-1));
		}
		if(sign==1) {
			if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else return (int) res;
		}
		else {
			if(-res<Integer.MIN_VALUE) return Integer.MAX_VALUE;
			else return -(int)res;
		}
	}
	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));
	}
}
