package LeetCode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s==null || s.length()==0) return true;
		s = s.toLowerCase();
		int head = 0;
		int tail = s.length()-1;
		while(head<=tail) {
			while(head<s.length() && !Character.isLetterOrDigit(s.charAt(head))) {
				head++;
			}
			while(tail>=0 && !Character.isLetterOrDigit(s.charAt(tail))) {
				tail--;
			}
			if(head<s.length() && tail>=0 && s.charAt(head)!=s.charAt(tail)) {
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}
}
