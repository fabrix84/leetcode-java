package LeetCode;

public class ZigZagConversion {
	public static String convert(String s, int nRows) {
		if(s.length()<=nRows || nRows==1)
			return s;
		StringBuffer[] lines = new StringBuffer[nRows];
		for(int i=0;i<lines.length;i++) {
			lines[i] = new StringBuffer();
		}
		int l=0;
		int i=0;
		while(i<s.length()) {
			while(l<lines.length && i<s.length()) {
				lines[l].append(s.charAt(i));
				l++;
				i++;
			}
			l-=2;
			while(l>=0 && i<s.length()) {
				lines[l].append(s.charAt(i));
				l--;
				i++;
			}
			l+=2;
		}
		StringBuffer buffer = new StringBuffer();
		for(StringBuffer sb:lines) {
			buffer.append(sb);
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		String s = "ABC";
		int n = 2;
		System.out.println(convert(s,n));
	}
}
