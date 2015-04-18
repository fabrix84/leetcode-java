package LeetCode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null) return null;
		ListNode walker = head;
		ListNode runner = head.next;
		while(runner.next!=null && runner.next.next!=null && walker!=runner) {
			runner = runner.next.next;
			walker = walker.next;
		}
		if(walker==runner) {
			walker = head;
			runner = runner.next;
			while(walker!=runner) {
				walker=walker.next;
				runner=runner.next;
			}
			return walker;
		}
		return null;
	}
}
