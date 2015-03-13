package LeetCode;

import java.util.*;
public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> indexes = new ArrayList<Integer>();
		if(L.length==0 || S.length()==0) return indexes;
		int nwords = L.length;
		int wordlen = L[0].length();
		int totallen = wordlen*nwords;
		if(S.length()<totallen) return indexes;
		Map<String,Integer> hash = strings2hash(L);
		for(int i=0;i<S.length()-totallen+1;i++) {
			Map<String,Integer> hcopy = new HashMap<String,Integer>(hash);
			int start = i;
			int counter = 0;
			String current = "";
			while(hcopy.size()>0 && start<S.length()-wordlen+1) {
				//System.out.println(start);
				//System.out.println(hcopy);
				current = S.substring(start,start+wordlen);
				if(hcopy.containsKey(current)) {
					if(hcopy.get(current)==1) {
						hcopy.remove(current);
					}
					else {
						int count = hcopy.get(current);
						hcopy.put(current, --count);
					}
					counter++;
					start=i+(wordlen*counter);
				}
				else {
					break;
				}
			}
			if(hcopy.size()==0) {
				indexes.add(i);
			}
		}
		return indexes;
	}
	public static Map<String,Integer> strings2hash(String[] L) {
		Map<String,Integer> s2h = new HashMap<String,Integer>();
		for(String s:L) {
			if(s2h.containsKey(s)) {
				int count = s2h.get(s);
				s2h.put(s, ++count);
			}
			else {
				s2h.put(s, 1);
			}
		}
		return s2h;
	}
	public static void main(String[] args) {
		String S = "abababab";
		String[] L = {"a","b","a"};
		System.out.println(findSubstring(S,L));
	}
}
