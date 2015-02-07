public class Atoi {
	public static int atoi(String str) {
		str = str.trim();
		if(str.length()==0) {
			return 0;
		}
		int sign = 1;
		if(str.charAt(0)=='-' || str.charAt(0)=='+') {
			if(str.charAt(0)=='-')
				sign = -1;
			str = str.substring(1);
		}
		int firstnondigit = 0;
		while(firstnondigit<str.length() && Character.isDigit(str.charAt(firstnondigit))) {
			firstnondigit++;
		}
		firstnondigit--;
		if(firstnondigit>10) {
			if(sign==-1) return -2147483648;
			if(sign==1) return 2147483647;
		}
		int v = 0;
		for(int i = firstnondigit;i>=0;i--) {
			String cs = String.valueOf(str.charAt(i));
			if(cs.matches(".*[^0-9]+.*")) {
				v=0;
			}
			else {
				int c = new Integer(cs);
				int multiplier = (int) Math.pow(10,firstnondigit-i);
				if(sign==1) {
					if(Integer.MAX_VALUE-(c*multiplier)>=v) {
						v = v + c*multiplier;
					}
					else {
						return 2147483647;
					}
				}
				else { //sign==-1
					if(Integer.MIN_VALUE+(c*multiplier)<=v) {
						v = v - c*multiplier;
					}
					else {
						return -2147483648;
					}
				}
			}
		}
		return v;
	}
	public static void main(String[] args) {
		System.out.println(atoi("-2147483649"));
	}
}
