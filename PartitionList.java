package LeetCode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode leftstart = new ListNode(0);
		ListNode rightstart = new ListNode(0);
		ListNode cleft = leftstart;
		ListNode cright = rightstart;
		while(head!=null) {
			if(head.val<x) {
				cleft.next = head;
				cleft = cleft.next;
			}
			else {
				cright.next = head;
				cright = cright.next;
			}
			head=head.next;
		}
		cleft.next = rightstart.next;
		cright.next = null;
		return leftstart.next;
	}
}
