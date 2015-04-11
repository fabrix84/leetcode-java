package LeetCode;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if(haystack==null ||  needle==null || needle.length()>haystack.length())
			return -1;
		if(needle.length()==0)
			return 0;
		for(int i=0;i<=haystack.length()-needle.length();i++) {
			if(haystack.charAt(i)==needle.charAt(0)) {
				int j;
				for(j=1;j<needle.length() && i+j<haystack.length();j++) {
					if(haystack.charAt(i+j)!=needle.charAt(j))
						break;
				}
				if(j==needle.length())
					return i;
			}
		}
		return -1;
	}
}
