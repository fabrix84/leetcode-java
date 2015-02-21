package LeetCode;

import java.util.*;

public class LRUCache {
	private List<Integer> priorities;
	private Map<Integer,Integer> lru;
	private int cap;
	
	public LRUCache(int capacity) {
		this.priorities = new ArrayList<Integer>();
		this.lru = new HashMap<Integer,Integer>();
		this.cap = capacity;
	}
	public int get(int key) {
		if(lru.containsKey(key)) {
			priorities.remove(new Integer(key));
			priorities.add(key);
			return lru.get(key);
		}
		else {
			return -1;
		}
	}
	public void set(int key, int value) {
		if(lru.containsKey(key)) {
			priorities.remove(new Integer(key));
		}
		else {
			if(lru.size()>=this.cap) {
				lru.remove(priorities.get(0));
				priorities.remove(0);
			}	
		}
		lru.put(key, value);
		priorities.add(key);
	}
}
