package LeetCode;

public class Candy {
	public int candy(int[] ratings) {
		int[] lp = new int[ratings.length];
		int[] rp = new int[ratings.length];
		int tot = 0;
		for(int i=0;i<ratings.length;i++) {
			lp[i]=1;
			rp[i]=1;
		}
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>ratings[i-1])
				lp[i]=lp[i-1]+1;
		}
		for(int i=ratings.length-2;i>=0;i--) {
			if(ratings[i]>ratings[i+1])
				rp[i]=rp[i+1]+1;
		}
		for(int i=0;i<ratings.length;i++) {
			tot = tot + Math.max(lp[i], rp[i]);
		}
		return tot;
	}
}
