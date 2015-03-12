package LeetCode;

public class SqrtX {
	public static int sqrt(int x) {
		if(x==0) return 0;
		if(x==1) return 1;
		long start = 0;
		long end = x;
		long el = (start+end)/2+1;
		while(start<=end) {
			if(el*el==x) return (int)el;
			else if(el*el>x) {
				end=el-1;
			}
			else {
				start=el+1;
			}
			el = (start+end)/2;
		}
		return (int)el;
	}
	public static void main(String[] args) {
		System.out.println(sqrt(2));
	}
}
