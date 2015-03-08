package LeetCode;

public class ReverseInteger {
	public static int reverse(int x) {
		int rev = 0;
		int tmp;
		int digit;
		int digits = 0;
		double exp;
		int sign = (x>=0)?1:-1;
		x=x*sign;
		double prevexp = 0.0;
		while(x>0) {
			tmp = x;
			//System.out.println("tmp: "+tmp);
			exp=0.0;
			while(tmp/(int)Math.pow(10.0, exp)>0 && exp<10) {
				exp++;
			}
			digit=x/(int)Math.pow(10.0, exp-1);
			while(prevexp-exp>1) {
				digits++;
				prevexp--;
			}
			//System.out.println("Exp: "+exp);
			//System.out.println("Digit: "+digit);
			if(sign==1 && Integer.MAX_VALUE-(digit*(Math.pow(10,digits)))<rev) return 0;
			if(sign==-1 && Integer.MIN_VALUE+(digit*(Math.pow(10,digits)))>-rev) return 0;
			rev = rev + (digit*((int)Math.pow(10,digits)));
			x = x - (digit*((int)Math.pow(10,exp-1)));
			prevexp = exp;
			digits++;
		}
		return rev*sign;
	}
	public static void main(String[] args) {
		System.out.println(reverse(901000));
	}
}
