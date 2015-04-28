package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size()<=1) {
			return intervals;
		}
		intervals = sort(intervals);
		List<Interval> l = new ArrayList<Interval>();
		Interval current = intervals.get(0);
		for(int i=1;i<intervals.size();i++) {
			Interval ci = intervals.get(i);
			if(current.end<ci.start) {
				l.add(current);
				current = ci;
			}
			else if(current.end>=ci.start && current.end<=ci.end){
				current.end = ci.end;
			}
		}
		l.add(current);
		return l;
	}
	public static List<Interval> sort(List<Interval> l) {
		if(l.size()<=1) {
			return l;
		}
		List<Interval> sorted = new ArrayList<Interval>();
		Interval pivot = l.remove(l.size()/2);
		List<Interval> left = new ArrayList<Interval>();
		List<Interval> right = new ArrayList<Interval>();
		for(Interval i: l) {
			if(i.start<pivot.start) {
				left.add(i);
			}
			else {
				right.add(i);
			}
		}
		sorted.addAll(sort(left));
		sorted.add(pivot);
		sorted.addAll(sort(right));
		return sorted;
	}
}
