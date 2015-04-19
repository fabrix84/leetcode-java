package LeetCode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";
		StringBuffer prefix = new StringBuffer();
		boolean flag = true;
		for(int i=0;i<strs[0].length();i++) {
			char c = strs[0].charAt(i);
			for(int j=0;j<strs.length;j++) {
				if(!(i<strs[j].length() && strs[j].charAt(i)==c)) {
					flag=false;
					break;
				}
			}
			if(flag) {
				prefix.append(c);
			}
			else {
				break;
			}
		}
		return prefix.toString();
	}
}
