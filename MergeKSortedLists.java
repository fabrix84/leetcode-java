package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0) return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>() {
		    public int compare(ListNode l1, ListNode l2) {
		        return l1.val-l2.val;
		    }
		});
		for(ListNode l: lists) {
		    if(l!=null)
			    heap.add(l);
		}
		if(heap.size()==0) return null;
		ListNode start = new ListNode(0);
		ListNode mergedtail = start;
		while(heap.size()>0) {
			ListNode min = heap.poll();
			mergedtail.next=min;
			if(min.next!=null) {
				heap.add(min.next);
			}
			mergedtail = mergedtail.next;
		}
		return start.next;
	}
}
