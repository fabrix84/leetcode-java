package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		Stack<String> postfix = new Stack<String>();
		Stack<Integer> helper = new Stack<Integer>();
		Set<String> ops = new HashSet<String>();
		ops.add("+");
		ops.add("-");
		ops.add("*");
		ops.add("/");
		for(int i=tokens.length-1;i>=0;i--) {
			postfix.push(tokens[i]);
		}
		while(!postfix.isEmpty()) {
			String next = postfix.pop();
			if(ops.contains(next)) {
				int op1 = Integer.valueOf(helper.pop());
				int op2 = Integer.valueOf(helper.pop());
				if(next.equals("+")) {
					helper.push(op2 + op1);
				}
				else if(next.equals("-")) {
					helper.push(op2 - op1);
				}
				else if(next.equals("*")) {
					helper.push(op2 * op1);
				}
				else if(next.equals("/")) {
					helper.push(op2 / op1);
				}
			}
			else {
				helper.push(Integer.valueOf(next));
			}
		}
		return helper.pop();
	}
	public static void main(String[] args) {
		String[] tokens = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
		System.out.println(evalRPN(tokens));
	}
}
