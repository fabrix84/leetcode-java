package LeetCode;

import java.util.*;

public class PalindromePartitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> solutions = new ArrayList<List<String>>();
		if(s==null || s.length()==0) return solutions;
		List<String> currsol = new ArrayList<String>();
		partitionHelper(0,currsol,solutions,s);
		return solutions;
	}
	public static void partitionHelper(int start, List<String> currsol, List<List<String>> solutions, String s) {
		if(start==s.length()) {
			solutions.add(new ArrayList<String>(currsol));
			return;
		}
		for(int i=start+1;i<=s.length();i++) {
			String sub = s.substring(start,i);
			if(isPal(sub)) {
				currsol.add(sub);
				int pos = currsol.size()-1;
				partitionHelper(i,currsol,solutions,s);
				currsol.remove(pos);
			}
		}
	}
	public static boolean isPal(String s) {
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "cbbbcc";
		System.out.println(partition(s));
	}
}
