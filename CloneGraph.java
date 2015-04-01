package LeetCode;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
	 
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
		Stack<UndirectedGraphNode> tovisit = new Stack<UndirectedGraphNode>();
		Map<Integer,UndirectedGraphNode> cloning = new HashMap<Integer,UndirectedGraphNode>();
		tovisit.push(node);
		cloning.put(node.label,new UndirectedGraphNode(node.label));
		while(tovisit.size()>0) {
			UndirectedGraphNode visiting = tovisit.pop();
			UndirectedGraphNode visitingClone = cloning.get(visiting.label);
			for(UndirectedGraphNode n: visiting.neighbors) {
				if(!cloning.containsKey(n.label)) {
					UndirectedGraphNode clone = new UndirectedGraphNode(n.label);
					visitingClone.neighbors.add(clone);
					cloning.put(n.label,clone);
					tovisit.push(n);
				}
				else {
					visitingClone.neighbors.add(cloning.get(n.label));
				}
			}
		}
		return cloning.get(node.label);
	}
}
