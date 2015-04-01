package LeetCode;

import java.util.*;

public class BSTIterator {
	List<TreeNode> mins;
	public BSTIterator(TreeNode root) {
		mins = new ArrayList<TreeNode>();
		while(root!=null) {
			mins.add(root);
			root=root.left;
		}
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (mins.size()>0)?true:false;
	}
    /** @return the next smallest number */
	public int next() {
		TreeNode min = mins.remove(mins.size()-1);
		TreeNode subright = min.right;
		while(subright!=null) {
			mins.add(subright);
			subright = subright.left;
		}
		return min.val;
	}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
