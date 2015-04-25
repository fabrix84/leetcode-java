package LeetCode;

import java.util.*;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		Stack<Integer> levels = new Stack<Integer>();
		tovisit.add(root);
		levels.add(1);
		int maxDepth = 1;
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			int level = levels.pop();
			if(level>maxDepth) maxDepth=level;
			if(visiting.right!=null) {
				tovisit.push(visiting.right);
				levels.push(level+1);
			}
			if(visiting.left!=null) {
				tovisit.push(visiting.left);
				levels.push(level+1);
			}
		}
		return maxDepth;
	}
	public static int maxDepth2(TreeNode root) {
		return maxDepthHelper(root,0);
	}
	public static int maxDepthHelper(TreeNode root, int level) {
		if(root==null) return level;
		return Math.max(maxDepthHelper(root.left,level+1),maxDepthHelper(root.right,level+1));
	}
	public static int maxDepth3(TreeNode root) {
		return (root==null)?0:Math.max(maxDepth3(root.left),maxDepth3(root.right))+1;
	}
}
