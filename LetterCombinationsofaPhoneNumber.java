package LeetCode;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> combs = new ArrayList<String>();
		if(digits==null || digits.length()==0) return combs;
		combs.add("");
		String[] digit2char = new String[10];
		digit2char[0] = " ";
		digit2char[1] = "";
		digit2char[2] = "abc";
		digit2char[3] = "def";
		digit2char[4] = "ghi";
		digit2char[5] = "jkl";
		digit2char[6] = "mno";
		digit2char[7] = "pqrs";
		digit2char[8] = "tuv";
		digit2char[9] = "wxyz";
		for(int i=0;i<digits.length();i++) {
			List<String> newcombs = new ArrayList<String>();
			int digit = Integer.parseInt(Character.toString(digits.charAt(i)));
			for(int j=0;j<digit2char[digit].length();j++) {
				char c = digit2char[digit].charAt(j);
				for(String s: combs) {
					String comb = s + c;
					newcombs.add(comb);
				}
			}
			combs = newcombs;
		}
		return combs;
	}
}
