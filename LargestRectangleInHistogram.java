package LeetCode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		int max = 0;
		Stack<Integer> indexes = new Stack<Integer>();
		Stack<Integer> heights = new Stack<Integer>();
		for(int i=0;i<height.length;i++) {
			if(heights.isEmpty() || height[i]>=heights.peek()) {
				indexes.push(i);
				heights.push(height[i]);
			}
			else {
				int lastIndex = 0;
				while(!heights.isEmpty() && heights.peek()>height[i]) {
					lastIndex = indexes.pop();
					int current = heights.pop()*(i-lastIndex);
					if(max<current)
						max=current;
				}
				indexes.push(lastIndex);
				heights.push(height[i]);
			}
		}
		while(!heights.isEmpty()) {
			int current = heights.pop()*(height.length-indexes.pop());
			if(current>max) {
				max=current;
			}
		}
		return max;
	}
}
