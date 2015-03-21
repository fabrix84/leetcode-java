package LeetCode;

import java.util.*;

class AutNode implements Comparable<AutNode> {
	char val;
	List<AutNode> nexts = new ArrayList<AutNode>();
	boolean end;
	public AutNode(){
		
	}
	public AutNode(char val) {
		this.val = val;
	}
	public int compareTo(AutNode node) {
		return node.val-this.val;
	}
	public String toString() {
		return this.val+"";
	}
}
public class WildCardMatching {
	public static boolean isMatch(String s, String p) {
		int minLength = 0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)!='*') minLength++;
		}
		if(minLength>s.length()) return false;
		if(s.length()==0) {
			return (p.length()==0 || p.charAt(0)=='*') ? true:false;
		}
		else if(p.length()==0)
			return false;
		List<AutNode> currentNodes = new ArrayList<AutNode>();
		currentNodes.add(buildAutomaton(p));
		if(currentNodes.get(0).val=='*'){
			//System.out.println("Adding to backtrack "+currentNodes.get(0).nexts);
			currentNodes.addAll(currentNodes.get(0).nexts);
		}
		boolean matched;
		AutNode node = new AutNode();
		List<AutNode> backtrack = new ArrayList<AutNode>();
		for(int i=0;i<s.length();i++) {
			matched = false;
			//System.out.println("Matching "+s.charAt(i));
			for(int j=0;j<currentNodes.size();j++) {
				node = currentNodes.get(j);
				//System.out.println("\t with "+node.val+" -> "+node.nexts);
				if(node.val==s.charAt(i)||node.val=='?'|| node.val=='*') {
					//System.out.println("\t Matched with "+node.val);
					if(i==s.length()-1 && node.end) return true;
					if(currentNodes.size()>1 && j==0) {
						//System.out.println("Adding to BackTrack "+currentNodes.get(j+1)+" -> "+currentNodes.get(j+1).nexts);
						backtrack = new ArrayList<AutNode>();
						backtrack.add(currentNodes.get(j+1));
					}
					currentNodes = node.nexts;
					if(currentNodes.size()>0 && currentNodes.get(0).val=='*' && currentNodes.size()>1) {
						Collections.reverse(currentNodes);
					}
					matched=true;
					break;
				}
			}
			if(!matched && backtrack.size()==0)
				return false;
			else if(matched==false || (i>=s.length()-1 && !node.end && backtrack.size()>0)){
				//System.out.println("Backtracking");
				i--;
				currentNodes.addAll(backtrack);
				backtrack.clear();
			}
		}
		if(currentNodes.get(0).val=='*' && currentNodes.get(0).end) return true;
		return false;
	}
	public static AutNode buildAutomaton(String p) {
		AutNode start = new AutNode(p.charAt(0));
		AutNode node = start;
		if(p.charAt(0)=='*') {
			node.nexts.add(node);
		}
		AutNode prev;
		prev = node;
		for(int i = 1; i<p.length();i++) {
			node = new AutNode(p.charAt(i));
			prev.nexts.add(node);
			if(p.charAt(i)=='*') {
				node.nexts.add(node);
			}
			prev = node;
		}
		node.end=true;
		return start;
	}
	public static void main(String[] args) {
		String s = "ab";
		String p = "*ab";
		System.out.println("\""+p+"\" match \""+s+"\" is "+isMatch(s,p));
	}
}
