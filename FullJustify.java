package LeetCode;

import java.util.*;

public class FullJustify {
	public static List<String> fullJustify(String[] words, int L) {
		if(words.length==0 || L==0) {
			List<String> l = new ArrayList<String>();
			l.add("");
			return l;
		}
		int first = 0;
		int last = 0;
		List<String> justs = new ArrayList<String>();
		while(first<words.length) {
			int linelength = words[first].length();
			while(last<words.length-1 && linelength+words[last+1].length()+1<=L) {
				last++;
				linelength=linelength+words[last].length()+1;
			}
			if(last==words.length-1 && first!=last) {
				String just = "";
				for(int i=first;i<=last-1;i++) {
					just+=words[i]+" ";
				}
				just+=words[last];
				int remaining = L-just.length();
				for(int s=0;s<remaining;s++) {
					just+=" ";
				}
				justs.add(just);
			}
			else if(first!=last) {
				linelength = linelength - (last-first);
				int remaining = L-linelength;
				int singlespace = remaining/(last-first);
				int modspace = remaining%(last-first);
				String just = "";
				for(int i =first;i<=last;i++) {
					just += words[i];
					if(i-first<modspace) {
						for(int s=0;s<singlespace+1;s++) {
							just+=" ";
						}
					}
					else if(i!=last){
						for(int s=0;s<singlespace;s++) {
							just+=" ";
						}
					}
				}
				justs.add(just);
			}
			else {
				String just = words[first];
				for(int s=0;s<L-words[first].length();s++) {
					just+=" ";
				}
				justs.add(just);
			}
			first=last+1;
			last=first;
		}
		return justs;
	}
	public static void main(String[] args) throws InterruptedException {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] words = {"What","must","be","shall","be."};
		int L = 16;
		List<String> l = fullJustify(words,L);
		for(String s: l) {
			System.out.println(s);
		}
	}
}
