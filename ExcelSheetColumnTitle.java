package LeetCode;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		if(n<1) return "";
		String title = "";
		int d = 0;
		int mod = n%26;
		if(mod==0) mod=26;
		while(n>26) {
			d = ((n-1)/26)%26;
			n = (n/26);
			if(d==0) {
				d=26;
				n--;
			}
			title = ((char)(d+64))+title;
		}
		return title+((char)(mod+64));
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(1)+" A");
		System.out.println(convertToTitle(2)+" B");
		System.out.println(convertToTitle(26)+" Z");
		System.out.println(convertToTitle(27)+" AA");
		System.out.println(convertToTitle(51)+" AY");
		System.out.println(convertToTitle(52)+" AZ");
		System.out.println(convertToTitle(53)+" BA");
		System.out.println(convertToTitle(77)+" BY");
		System.out.println(convertToTitle(78)+" BZ");
		System.out.println(convertToTitle(79)+" CA");
		System.out.println(convertToTitle(675)+" YY");
		System.out.println(convertToTitle(676)+" YZ");
		System.out.println(convertToTitle(677)+" ZA");
		System.out.println(convertToTitle(702)+" ZZ");
		System.out.println(convertToTitle(703)+" AAA");
		System.out.println(convertToTitle(1048)+" ANH");
	}
}
