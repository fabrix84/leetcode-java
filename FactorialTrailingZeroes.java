package LeetCode;

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		int zeroes = 0;
		while(n>=5) {
			zeroes+=n/5;
			n=n/5;
		}
		return zeroes;
	}
	public static void main(String[] args) {
		int n = 100;
		System.out.println("fact "+n+" has "+trailingZeroes(n)+" trailing zeroes.");
	}
}
