package LeetCode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
		Stack<TreeNode> currentlevel = new Stack<TreeNode>();
		Stack<TreeNode> nextlevel = new Stack<TreeNode>();
		if(root!=null) nextlevel.push(root);
		boolean lefttoright=false;
		while(!nextlevel.empty()) {
			currentlevel = nextlevel;
			nextlevel = new Stack<TreeNode>();
			List<Integer> nlevel = new ArrayList<Integer>();
			while(!currentlevel.empty()) {
				TreeNode n = currentlevel.pop();
				nlevel.add(n.val);
				if(lefttoright) { // zig
					if(n.right!=null) nextlevel.push(n.right);
					if(n.left!=null) nextlevel.push(n.left);
				}
				else { // zag
					if(n.left!=null) nextlevel.push(n.left);
					if(n.right!=null) nextlevel.push(n.right);
				}
			}
			zigzag.add(nlevel);
			lefttoright=(lefttoright)?false:true;
		}
		return zigzag;
	}
}
