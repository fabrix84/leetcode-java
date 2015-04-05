package LeetCode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		return subListToBst(head,null);
	}
	public static TreeNode subListToBst(ListNode start, ListNode end) {
		if(start==null || start==end) return null;
		if(start.next==end) return new TreeNode(start.val);
		ListNode slow = start;
		ListNode fast = start;
		while(fast!=end && fast.next!=end && fast.next.next!=end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode bst = new TreeNode(slow.val);
		bst.left = subListToBst(start,slow);
		bst.right = subListToBst(slow.next,end);
		return bst;
	}
}
