package LeetCode;

import java.util.*;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new LinkedList<Integer>();
		inorderHelper(root,inorder);
		return inorder;
	}
	public void inorderHelper(TreeNode root, List<Integer> inorder) {
		if(root==null) return;
		inorderHelper(root.left,inorder);
		inorder.add(root.val);
		inorderHelper(root.right,inorder);
	}
	public List<Integer> inorderTraversalIT(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		if(root==null) return inorder;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			if(visiting.right!=null && !visited.contains(visiting)) tovisit.push(visiting.right);
			if(!visited.contains(visiting)) tovisit.push(visiting);
			else inorder.add(visiting.val);
			if(visiting.left!=null && !visited.contains(visiting)) tovisit.push(visiting.left);
			if(!visited.contains(visiting)) visited.add(visiting);
		}
		return inorder;
	}
}
