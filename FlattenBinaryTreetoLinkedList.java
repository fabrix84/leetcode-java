package LeetCode;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		while(root!=null) {
			if(root.left!=null) {
				TreeNode subleftrightmost = root.left;
				while (subleftrightmost.right != null) { subleftrightmost = subleftrightmost.right; }
				subleftrightmost.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}
