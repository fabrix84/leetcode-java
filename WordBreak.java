package LeetCode;

import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		Map<String,Boolean> hash = new HashMap<String,Boolean>();
		return wordBreakRec(s,dict,hash);
	}
	public boolean wordBreakRec(String s, Set<String> dict, Map<String,Boolean> hash) {
		if(s==null) return false;
		if(s.length()==0) return true;
		if(hash.containsKey(s))
			return hash.get(s);
		for(String word: dict) {
			String news = "";
			if(word.length()<=s.length())
				news = s.substring(0, word.length());
			if(news.equals(word)) {
				if(wordBreakRec(s.substring(word.length()),dict,hash)) {
					hash.put(s, true);
					return true;
				}
			}
		}
		hash.put(s, false);
		return false;
	}
}
