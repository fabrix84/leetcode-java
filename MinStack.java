package LeetCode;

import java.util.*;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();
	public void push(int x) {
		stack.push(x);
		if(min.size()==0 || min.peek()>=x)
			min.push(x);
	}
	public void pop() {
		if(stack.peek()<=min.peek()) {
			min.pop();
		}
		stack.pop();
	}
	public int top() {
		return stack.peek();
	}
	public int getMin() {
		return min.peek();
	}
}
