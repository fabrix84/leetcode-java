package LeetCode;

public class Numberof1Bits {
	public static int hammingWeight(int n) {
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1);
			n = n>>>1;
		}
		return ones;
	}
	public static void main(String[] args) {
		int n = 2147483647;
		System.out.println(hammingWeight(n));
	}
}
