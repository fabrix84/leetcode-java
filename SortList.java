package LeetCode;

public class SortList {
	public static ListNode sortList(ListNode head) {
		if(head==null) return null;
		if(head.next==null) return head;
		ListNode leftstart = new ListNode(0);
		ListNode left = leftstart;
		ListNode rightstart = new ListNode(0);
		ListNode right = rightstart;
		int count = 0;
		while(head!=null) {
			if(count%2==0) {
				left.next = head;
				left = left.next;
				head = head.next;
			}
			else {
				right.next = head;
				right = right.next;
				head = head.next;
			}
			count++;
		}
		if(right!=null) {
		    right.next=null;
		}
		if(left!=null) {
		    left.next=null;
		}
		ListNode ordered = merge(sortList(leftstart.next),sortList(rightstart.next));
		return ordered;
	}
	public static ListNode merge(ListNode left, ListNode right) {
		ListNode mergedstart = new ListNode(0);
		ListNode merged = mergedstart;
		while(left!=null || right!=null) {
			if(left!=null && right!=null) {
				if(left.val<right.val) {
					merged.next = left;
					merged = merged.next;
					left = left.next;
				}
				else {
					merged.next = right;
					merged = merged.next;
					right = right.next;
				}
			}
			else if(left!=null) {
				merged.next = left;
				merged = merged.next;
				left = left.next;
			}
			else {
				merged.next = right;
				merged = merged.next;
				right = right.next;
			}
		}
		return mergedstart.next;
	}
}
