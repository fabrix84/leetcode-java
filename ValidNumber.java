package LeetCode;

public class ValidNumber {
	public static boolean isNumber(String s) {
		//char[] chars = s.toCharArray();
		s = s.trim();
		if(s.length()==0) return false;
		boolean pointseen = false;
		boolean eseen = false;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if((c=='-' || c=='+') && (i==0 || (i>0 && s.charAt(i-1)=='e' && i<s.length()-1 && isDigit(s.charAt(i+1))) ) ) {
				continue;
			}
			if(!isDigit(c)) {
				//System.out.println(s.charAt(i));
				if(c=='.') {
					if(pointseen || eseen) {
						return false;
					}
					else {
						if((i<s.length()-1 && (isDigit(s.charAt(i+1)) || s.charAt(i+1)=='e')) || (i>0 && isDigit(s.charAt(i-1))))
							pointseen = true;
						else return false;
					}
				}
				else if(c=='e') {
					if(eseen) {
						return false;
					}
					else {
						if(i<s.length()-1 && (isDigit(s.charAt(i+1)) || s.charAt(i+1)=='+' || s.charAt(i+1)=='-') && 
							i>0 && (isDigit(s.charAt(i-1)) || (i>1 && s.charAt(i-1)=='.' && isDigit(s.charAt(i-2))))
						) {
							eseen = true;
						}
						else {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isDigit(char c) {
		return (c<'0' || c>'9')? false : true;
	}
	public static void main(String[] args) {
		String s = "4e+";
		System.out.println(isNumber(s));
	}
}
