package LeetCode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode merged = new ListNode(0);
		ListNode curr = merged;
		while(l1!=null || l2!=null) {
			if(l1==null) {
				curr.next = l2;
				l2 = l2.next;
			}
			else if(l2==null) {
				curr.next=l1;
				l1=l1.next;
			}
			else {
				if(l1.val>l2.val) {
					curr.next=l2;
					l2=l2.next;
				}
				else {
					curr.next=l1;
					l1=l1.next;
				}
			}
			curr=curr.next;
		}
		return merged.next;
	}
}
