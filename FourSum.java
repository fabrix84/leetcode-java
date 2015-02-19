package LeetCode;

import java.util.*;
public class FourSum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		Set<List<Integer>> l = new HashSet<List<Integer>>();
		if(num.length<4) return new ArrayList<List<Integer>>(l);
		Arrays.sort(num);
		for(int i=0;i<num.length-1;i++) {
			for(int j=i+1;j<num.length;j++) {
				int k = j+1;
				int z = num.length-1;
				while(k<z) {
					int tot = num[i]+num[j]+num[k]+num[z];
					if(tot==target) {
						List<Integer> quad = new ArrayList<Integer>();
						quad.add(num[i]);
						quad.add(num[j]);
						quad.add(num[k]);
						quad.add(num[z]);
						l.add(quad);
						k++;
					}
					else if(tot<target) {
						k++;
					}
					else { //tot>target
						z--;
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(l);
	}
	public static int[] genNum(int n) {
		int[] num = new int[n];
		Random r = new Random();
		for(int i=0;i<n;i++) {
			num[i] = r.nextInt(10)-5;
		}
		return num;
	}
	public static void printNum(int[] num) {
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		//int[] num = genNum(10);
		int[] num = {1,0,-1,0,-2,2};
		printNum(num);
		Arrays.sort(num);
		printNum(num);
		System.out.println(fourSum(num,0));
	}
}
