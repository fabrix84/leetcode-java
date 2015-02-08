package LeetCode;

public class CompareVersionNumber {
	public static int compareVersion(String version1, String version2) {
		version1 = removeLeadingZeroes(version1);
		String[] v1 = version1.split("\\.");
		version2 = removeLeadingZeroes(version2);
		String[] v2 = version2.split("\\.");
		int maxLen = Math.max(v1.length, v2.length);
		for(int i=0;i<maxLen;i++) {
			if(i<v1.length && i< v2.length) {
				if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i])) {
					return 1;
				}
				else if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i])) {
					return -1;
				}
				else if(v1.length==i+1 && v2.length==i+1){
					return 0;
				}
			}
			else if(i<v1.length) {
				if(Integer.parseInt(v1[i])==0 && i+1==v1.length) 
					return 0;
				else if(Integer.parseInt(v1[i])==0)
					continue;
				else
					return 1;
			}
			else if(i<v2.length){
				if(Integer.parseInt(v2[i])==0 && i+1==v2.length) 
					return 0;
				else if(Integer.parseInt(v2[i])==0)
					continue;
				else
					return -1;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	public static String removeLeadingZeroes(String s) {
		if(s.length()==1 && s.charAt(0)=='0') {
			return s;
		}
		if(s.length()>1 && s.charAt(0)=='0' && s.charAt(1)=='.') {
			return s;
		}
		if(s.length()>0 && s.charAt(0)=='.') {
			return "0"+s;
		}
		int i = 0;
		while(i<s.length() && s.charAt(i)=='0') {
			i++;
		}
		String ss = s.substring(i);
		return ss;
	}
	public static void main(String[] args) {
		String v1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		String v2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		System.out.println(v1+" compare to "+v2+" = "+compareVersion(v1,v2));
	}
}
