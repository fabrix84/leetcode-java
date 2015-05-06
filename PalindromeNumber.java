package LeetCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		int tmp = x;
		int rev = 0;
		while(tmp>0) {
			rev = rev*10 + tmp%10;
			tmp = tmp/10;
		}
		return x==rev;
	}
}
