package LeetCode;

import java.util.*;

public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> dict) {
		if(dict.size()==0 || s.length()==0) return new ArrayList<String>();
		Set<Character> salphabet = new HashSet<Character>();
		for(char c : s.toCharArray()) {
		    salphabet.add(c);
		}
		StringBuilder alldict = new StringBuilder();
		for(String dw: dict) {
			alldict.append(dw);
		}
		Set<Character> dictalphabet = new HashSet<Character>();
		for(char c : alldict.toString().toCharArray()) {
		    dictalphabet.add(c);
		}
		for(char c:salphabet) {
			if(!dictalphabet.contains(c)) {
				return new ArrayList<String>();
			}
		}
		Map<Integer, List<String>> computed = new HashMap<Integer,List<String>>();
		List<String>sentences = wordBreakRec(0,s,dict,computed);
		return sentences;
	}
	public static List<String> wordBreakRec(Integer si, String s, Set<String> dict, Map<Integer, List<String>> computed) {
		if(computed.containsKey(si)) return computed.get(si);
		if(si-s.length()==0) return new ArrayList<String>();
		List<String> sentences = new ArrayList<String>();
		StringBuilder curr = new StringBuilder();
		String currs = "";
		for(int i=si;i<s.length();i++) {
			curr.append(s.charAt(i));
			currs = curr.toString();
			if(dict.contains(currs) && i!=s.length()-1) {
				for(String bs: wordBreakRec(i+1,s,dict,computed)) {
					sentences.add(currs+" "+bs);
				}
			}
			else if(dict.contains(currs)) {
				sentences.add(currs);
			}
		}
		computed.put(si, sentences);
		return sentences;
	}
	public static void main(String[] args) {
		String s = "catsanddog";
		//String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>(Arrays.asList("cat","cats","and","sand","dog","catsand","san","d","c","atsand"));
		//Set<String> dict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
		System.out.println(wordBreak(s,dict));
	}
}
