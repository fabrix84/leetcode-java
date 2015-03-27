package LeetCode;

import java.util.*;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> anagrams = new ArrayList<String>();
		if(strs==null || strs.length==0) {
			return anagrams;
		}
		Map<String,List<String>> hash = new HashMap<String,List<String>>();
		for(String s: strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String sorteds = new String(ca);
			if(hash.containsKey(sorteds)) {
				hash.get(sorteds).add(s);
			}
			else {
				List<String> ls = new ArrayList<String>();
				ls.add(s);
				hash.put(sorteds, ls);
			}
		}
		for(String key: hash.keySet()) {
			List<String> angramsgroup = hash.get(key);
			if(angramsgroup.size()>1) {
				anagrams.addAll(angramsgroup);
			}
		}
		return anagrams;
	}
}
