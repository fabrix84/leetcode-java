package LeetCode;

import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}
	 
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        Map<Integer,RandomListNode> hash = new HashMap<Integer,RandomListNode>();
        RandomListNode current = head;
        while(current!=null){
            hash.put(current.label,new RandomListNode(current.label));
            current=current.next;
        }
        current = head;
        while(current!=null){
            RandomListNode copy = hash.get(current.label);
            if(current.next!=null) {
            	copy.next = hash.get(current.next.label);
            }
            if(current.random!=null) {
	            if(hash.containsKey(current.random.label)) {
	            	copy.random = hash.get(current.random.label);
	            }
	            else {
	            	RandomListNode randomcopy = new RandomListNode(current.random.label);
	            	hash.put(randomcopy.label, randomcopy);
	            	copy.random = randomcopy;
	            }
            }
            current=current.next;
        }
        return hash.get(head.label);
    }
}
