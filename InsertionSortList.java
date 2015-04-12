package LeetCode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode start = new ListNode(0);
		start.next = head;
		int sorted = 1;
		ListNode toSort = head.next;
		head.next = null;
		while(toSort!=null) {
			ListNode nextToSort = toSort.next;
			ListNode current = start.next;
			ListNode prev = start;
			int pos = 0;
			while(pos<sorted) {
				if(toSort.val<=current.val) {
					prev.next = toSort;
					toSort.next = current;
					sorted++;
					break;
				}
				else {
					prev = current;
					current = current.next;
					pos++;
				}
			}
			if(pos==sorted) {
				prev.next = toSort;
				toSort.next = current;
				sorted++;
			}
			toSort = nextToSort;
		}
		return start.next;
	}
}
