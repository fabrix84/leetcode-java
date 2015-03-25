package LeetCode;

public class AddBinary {
	public static String addBinary(String a, String b) {
		if(a.length()==0 && b.length()==0) return "";
		if(b.length()==0) return a;
		if(a.length()==0) return b;
		StringBuffer sum = new StringBuffer();
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int ai = a.length()-1;
		int bi = b.length()-1;
		int carry = 0;
		int add = 0;
		while(ai>=0 && bi>=0) {
			int add1 = (aa[ai]=='1') ? 1 : 0 ;
			int add2 = (bb[bi]=='1') ? 1 : 0 ;
			add = (add1+add2+carry)%2;
			carry = (add1+add2+carry)/2;
			sum.insert(0, add);
			ai--;
			bi--;
		}
		while(ai>=0) {
			int add1 = (aa[ai]=='1') ? 1 : 0 ;
			add = (add1+carry)%2;
			carry = (add1+carry)/2;
			sum.insert(0, add);
			ai--;
		}
		while(bi>=0) {
			int add1 = (bb[bi]=='1') ? 1 : 0 ;
			add = (add1+carry)%2;
			carry = (add1+carry)/2;
			sum.insert(0, add);
			bi--;
		}
		if(carry>0) {
			sum.insert(0, carry);
		}
		return sum.toString();
	}
	public static void main(String[] args) {
		String a = "0";
		String b = "1";
		System.out.println(addBinary(a,b));
	}
}
