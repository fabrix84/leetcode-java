package LeetCode;

public class ReorderList {
	public static void printList(ListNode head) {
		do {
			System.out.print(head.val+" -> ");
			head = head.next;
		}
		while(head!=null);
		System.out.println();
	}
	public static void reorderList(ListNode head) {
		if(head==null) return;
		ListNode p = head;
		ListNode q = head;
		while(p.next!=null && q.next!=null && q.next.next!=null) {
			p = p.next;
			q = q.next.next;
		}
		q = p.next;
		p.next = reverseList(q);
		printList(head);
		q = p.next;
		printList(q);
		q = head;
		while(p!=q && p.next!=null) {
			ListNode temp = q.next;
			q.next = p.next;
			p.next = p.next.next;
			q.next.next = temp;
			q = q.next.next;
		}
	}
	public static ListNode reverseList(ListNode head) {
		ListNode newhead = null;
		while(head!=null) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			head = next;
		}
		return newhead;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		//l4.next=l5;
		printList(l1);
		reorderList(l1);
		printList(l1);
	}
}
