package LeetCode;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode current = headA;
		while(current.next!=null) current = current.next;
		current.next = headA;
		ListNode slow = headB;
		ListNode fast = headB;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow == fast) break;
		}
		if (fast.next==null || fast.next.next==null) {
			current.next = null;
			return null;
		}
		slow = headB;
		while (slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        current.next = null;
        return fast;
    }
}
