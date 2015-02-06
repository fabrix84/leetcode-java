package LeetCode;

import java.util.*;
public class RepeatedDNAsequence {
	public static List<String> findRepeatedDnaSequences(String s) {
		if(s.length()<10) return new ArrayList<String>();
		Set<String> repseq = new HashSet<String>();
		Set<Integer> hash = new HashSet<Integer>();
		for(int i=0;i<=s.length()-10;i++) {
			String curr = s.substring(i, i+10);
			int intcurr = s2b(curr);
			if(hash.contains(intcurr)) {
				repseq.add(curr);
			}
			else {
				hash.add(intcurr);
			}
		}
		return new ArrayList<String>(repseq);
	}
	public static int s2b(String s) {
		int sb = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='A') sb=sb+0;
			if(s.charAt(i)=='C') sb=sb+1;
			if(s.charAt(i)=='G') sb=sb+2;
			if(s.charAt(i)=='T') sb=sb+3;
			if(i!=s.length()-1) sb = sb<<2;
		}
		return sb;
	}
	public static String b2s(int b) {
		String s = Integer.toBinaryString(b);
		while(s.length()<20) {
			s='0'+s;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i=i+2) {
			String curr = s.substring(i, i+2);
			if(curr.equals("00")) sb.append('A');
			if(curr.equals("01")) sb.append('C');
			if(curr.equals("10")) sb.append('G');
			if(curr.equals("11")) sb.append('T');
		}
		return sb.toString();
	}
	public static String genDNA(int n) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		String ALPHABET = "ACGT";
		for(int i=0;i<n;i++) {
			sb.append(ALPHABET.charAt(r.nextInt(4)));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = genDNA(1000);
		System.out.println(findRepeatedDnaSequences(s));
	}
}
