package LeetCode;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Max {
	int val = Integer.MIN_VALUE;
}

public class BinaryTreeMaximumPathSum {
	public static int maxPathSum(TreeNode root) {
		if(root==null) return 0;
		Max max = new Max();
		gmp(root,max);
		return max.val;
	}
	public static int gmp(TreeNode root, Max max) {
		int mp;
		int joinedmp = Integer.MIN_VALUE;
		if(root==null) mp = Integer.MIN_VALUE;
		else if(root.left==null && root.right==null) mp = root.val;
		else if(root.left==null) {
			int maxright = gmp(root.right, max);
			mp = Math.max(root.val, root.val+maxright);
		}
		else if(root.right==null) {
			int maxleft = gmp(root.left, max);
			mp = Math.max(root.val, root.val+maxleft);
		}
		else {
			int maxright = gmp(root.right, max);
			int maxleft = gmp(root.left, max);
			mp = Math.max(root.val, Math.max(root.val+maxleft,root.val+maxright));
			joinedmp = root.val+maxleft+maxright;
		}
		max.val = Math.max(max.val, Math.max(mp, joinedmp));
		return mp;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(-3);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(-4);
		n1.left=n2;
		n2.left=n3;
		n3.right=n4;
		n4.left=n5;
		System.out.println(maxPathSum(n1));
		System.out.println("Max path from "+n1.val+": "+gmp(n1, new Max()));
		System.out.println("Max path from "+n2.val+": "+gmp(n2, new Max()));
		System.out.println("Max path from "+n3.val+": "+gmp(n3, new Max()));
		System.out.println("Max path from "+n4.val+": "+gmp(n4, new Max()));
		System.out.println("Max path from "+n5.val+": "+gmp(n5, new Max()));
	}
}
