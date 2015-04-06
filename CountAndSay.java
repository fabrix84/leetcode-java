package LeetCode;

public class CountAndSay {
	public static String countAndSay(int n) {
		if(n<1) return "";
		if(n==1) return "1";
		String reads = "1";
		for(int k=2;k<=n;k++) {
			StringBuffer buff = new StringBuffer();
			for(int i=0;i<reads.length();i++) {
				char c = reads.charAt(i);
				int count = 1;
				while(i+1<reads.length() && reads.charAt(i+1)==c) {
					count++;
					i++;
				}
				buff.append(count);
				buff.append(c);
			}
			reads = buff.toString();
		}
		return reads;
	}
	public static void main(String[] args) {
		int n = 10;
		System.out.println(countAndSay(n));
	}
}
