package LeetCode;

import java.util.*;

public class LargestNumber {
	public static String largestNumber(int[] num) {
		if(num.length==0) return "0";
		List<String> l = new LinkedList<String>();
		for(int i=0;i<num.length;i++) {
			l.add(String.valueOf(num[i]));
		}
		l = sortLargest(l);
		StringBuilder largest = new StringBuilder();
		for(String s: l) {
			largest.append(s);
		}
		return removeZeroes(largest.toString());
	}
	public static List<String> sortLargest(List<String> l) {
		if(l.size()<=1) return l;
		int middle = l.size()/2;
		String pivot = l.remove(middle);
		List<String> left  = new ArrayList<String>();
		List<String> right = new ArrayList<String>();
		for(String s: l) {
			if(ncompare(s,pivot)==-1) {
				left.add(s);
			}
			else {
				right.add(s);
			}
		}
		List<String> sorted = new ArrayList<String>();
		sorted.addAll(sortLargest(left));
		sorted.add(pivot);
		sorted.addAll(sortLargest(right));
		return sorted;
	}
	public static int ncompare(String s, String t) {
		String is = s+t;
		String it = t+s;
		if(s.equals(t)) return 0;
		for(int i=0;i<it.length();i++) {
			if(is.charAt(i)<it.charAt(i))
				return 1;
			else if(is.charAt(i)>it.charAt(i))
				return -1;
		}
		return 0;
	}
	public static String removeZeroes(String s) {
		if(s.length()>1 && s.charAt(0)=='0') {
			int i = 1;
			while(i<s.length() && s.charAt(i)=='0') {
				i++;
			}
			return "0"+s.substring(i);
		}
		else {
			return s;
		}
	}
	public static void main(String[] args) {
		int[] numbers = {128,12};
		System.out.println(largestNumber(numbers));
	}
}
