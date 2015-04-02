package LeetCode;

import java.util.*;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		if(candidates==null || candidates.length==0) return sets;
		Arrays.sort(candidates);
		sets.addAll(genSets(candidates, 0, new ArrayList<Integer>(), target));
		return sets;
	}
	public static Set<List<Integer>> genSets(int[] candidates, int i, List<Integer> set, int target) {
		Set<List<Integer>> sets = new HashSet<List<Integer>>();
		if(target==0) {
			sets.add(new ArrayList<Integer>(set));
			return sets;
		}
		if(target<0) {
			return sets;
		}
		if(i>=candidates.length || candidates[i]>target) {
			return sets;
		}
		set.add(candidates[i]);
		sets.addAll(genSets(candidates, i, set, target-candidates[i]));
		set.remove(new Integer(candidates[i]));
		if(i<candidates.length-1) {
			sets.addAll(genSets(candidates, i+1, set, target));
			if(target-candidates[i]>=0) {
				set.add(candidates[i]);
				sets.addAll(genSets(candidates, i+1, set, target-candidates[i]));
				set.remove(new Integer(candidates[i]));
			}
		}
		return sets;
	}
	public static void main(String[] args) {
		int[] A = {92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		int target = 310;
		System.out.println(combinationSum(A,target));
	}
}
