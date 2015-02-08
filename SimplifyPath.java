package LeetCode;

import java.util.*;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		StringBuilder sp = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		String[] tokens = path.split("/");
		for(String s: tokens) {
			if(s.length()>0) {
				if(s.equals("..")) {
					if(!stack.empty())
						stack.pop();
				}
				else if(s.equals(".")) {
					continue;
				}
				else {
					stack.push(s);
				}
			}
		}
		while(!stack.empty()) {
			sp.insert(0,stack.pop());
			sp.insert(0, "/");
		}
		if(sp.length()==0) sp.append("/");
		return sp.toString();
	}
	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		System.out.println(simplifyPath(s));
	}
}
