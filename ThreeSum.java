package LeetCode;

import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		if(num.length<3) return new ArrayList<List<Integer>>();
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		int i,j,k;
		int a, b, c;
		Arrays.sort(num);
		for(i=0;i<num.length-2;i++) {
			if(i==0 || num[i]>num[i-1]) {
				j=i+1;
				k=num.length-1;
				a = num[i];
				while(j<k) {
					b = num[j];
					c = num[k];
					if(a+b+c==0) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(a);
						l.add(b);
						l.add(c);
						triplets.add(l);
						j++;
						k--;
						while(j<k && num[j]==num[j-1]) j++;
						while(k>j && num[k]==num[k+1]) k--;
					}
					else if(a+b+c<0) {
						j=j+1;
					}
					else {
						k=k-1;
					}
				}
			}
		}
		return triplets;
	}
	public List<List<Integer>> threesum(int[] num) {
		if(num.length<3) return new ArrayList<List<Integer>>();
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		int start = 0;
		while(start<num.length && num[start]<0) start++;
		for(int i=start;i<num.length;i++) {
			for(int j=0;j<i-1;j++) {
				if(-(num[i]+num[j])>=num[j+1]) {
					for(int k=j+1;k<i;k++) {
						if(num[i]==-(num[j]+num[k])) {
							List<Integer> triplet = new ArrayList<Integer>();
							triplet.add(num[j]);
							triplet.add(num[k]);
							triplet.add(num[i]);
							triplets.add(triplet);
							while(j<i-1 && num[j]==num[j+1]) {
								j++;
							}
							break;
						}
						else if(-num[i]<num[j]+num[k]) {
							break;
						}
					}
				}
			}
		}
		return triplets;
	}
	public List<List<Integer>> hashThreeSum(int[] num) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		Map<Integer,List<Integer>> ht = new HashMap<Integer,List<Integer>>();
		for(int i=1;i<num.length;i++) {
			if(ht.containsKey(num[i])) {
				List<Integer> triplet = new ArrayList<Integer>();
				triplet.add(num[i]);
				triplet.addAll(ht.get(num[i]));
				triplets.add(triplet);
			}
			for(int j=0;j<i;j++) {
				int sum = num[i]+num[j];
				List<Integer> pair = new ArrayList<Integer>();
				pair.add(num[i]);
				pair.add(num[j]);
				ht.put(-sum,pair);
			}
		}
		return triplets;
	}
}
