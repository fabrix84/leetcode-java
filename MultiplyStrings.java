package LeetCode;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		if(num1.length()==0 || num2.length()==0) return "0";
		if(num1.length()<10 && Integer.valueOf(num1)==0) return "0";
		if(num2.length()<10 && Integer.valueOf(num2)==0) return "0";
		String result = "";
		String prevtemp = "";
		int pos = 0;
		int partial = 0;
		for(int i=num2.length()-1;i>=0;i--) {
			StringBuilder temp = new StringBuilder();
			int carry = 0;
			int n2 = Integer.valueOf(""+num2.charAt(i));
			for(int j=num1.length()-1;j>=0;j--) {
				int n1 = Integer.valueOf(""+num1.charAt(j));
				int p = n1*n2;
				p = p + carry;
				partial = p%10;
				carry = p/10;
				temp.insert(0, partial);
			}
			if(carry>0) {
				temp.insert(0, carry);
			}
			for(int k=0;k<pos;k++) {
				temp.append('0');
			}
			result = sum(prevtemp,temp.toString());
			prevtemp = result;
			pos++;
		}
		return result;
	}
	public static String sum(String s1, String s2) {
		while(s1.length()<s2.length()) {
			s1="0"+s1;
		}
		while(s2.length()<s1.length()) {
			s2="0"+s2;
		}
		StringBuilder res = new StringBuilder();
		int carry = 0;
		for(int i=s1.length()-1;i>=0;i--) {
			int add = (Integer.valueOf(""+s1.charAt(i))+Integer.valueOf(""+s2.charAt(i)));
			int partial = (add+carry)%10;
			carry = (add+carry)/10;
			res.insert(0, partial);
		}
		if(carry>0) {
			res.insert(0, carry);
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String num1 = "65539";
		String num2 = "83314";
		System.out.println(num1+"*"+num2+" = "+multiply(num1,num2)+" "+(Long.valueOf(num1)*Long.valueOf(num2)));
		System.out.println(num1+"+"+num2+" = "+sum(num1,num2)+" "+(Integer.valueOf(num1)+Integer.valueOf(num2)));
	}
}
