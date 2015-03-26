package LeetCode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode res = new ListNode(0);
		int addend = 0;
		int carry = 0;
		ListNode lr = res;
		while(l1!=null || l2!=null) {
			if(l1!=null && l2!=null) {
				addend = l1.val+l2.val+carry;
				if(addend>=10) {
					carry = 1;
					addend = addend % 10;
				}
				else {
					carry = 0;
				}
				lr.next = new ListNode(addend);
				lr = lr.next;
			}
			else if(l1!=null) {
				addend = l1.val+carry;
				if(addend>=10) {
					carry=1;
					addend = addend % 10;
				}
				else {
					carry = 0;
				}
				lr.next = new ListNode(addend);
				lr = lr.next;
			}
			else { // l2!=null
				addend = l2.val+carry;
				if(addend>=10) {
					carry=1;
					addend = addend % 10;
				}
				else {
					carry = 0;
				}
				lr.next = new ListNode(addend);
				lr = lr.next;
			}
			if(l1!=null)l1 = l1.next;
			if(l2!=null)l2 = l2.next;
		}
		if(carry>0) {
			lr.next = new ListNode(carry);
		}
		return res.next;
	}
}
