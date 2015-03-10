package LeetCode;

public class ReverseWords {
	public String reverseWords(String s) {
		if(s==null || s.length()==0) return s;
		StringBuilder o = new StringBuilder();
		int i = s.length()-1;
		while(i>=0 && s.charAt(i)==' ') {
			i--;
		}
		int wend;
		while(i>=0) {
			wend = i;
			while(i>=0 && s.charAt(i)!=' ') {
				i--;
			}
			o.append(s.substring(i+1, wend+1));
			while(i>=0 && s.charAt(i)==' ') {
				i--;
			}
			if(i>=0) {
				o = o.append(' ');
			}
		}
		return o.toString();
	}
}
