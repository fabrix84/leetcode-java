package LeetCode;

import java.util.Arrays;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) return null;
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		if(postorder.length==1) return root;
		int rootindex = -1;
		for(int i=0;i<inorder.length;i++) { if(inorder[i]==root.val) { rootindex=i; break; } }
		int[] inordersubleft    = Arrays.copyOfRange(inorder, 0, rootindex);
		int[] inordersubright   = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
		int[] postordersubleft  = Arrays.copyOfRange(postorder, 0, rootindex);
		int[] postordersubright = Arrays.copyOfRange(postorder, rootindex, postorder.length-1);
		root.left  = buildTree(inordersubleft,postordersubleft);
		root.right = buildTree(inordersubright,postordersubright);
		return root;
	}
}
