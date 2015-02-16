package LeetCode;

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	public String toString() {
		return "("+this.start+","+this.end+")";
	}
}

public class InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> newlist = new ArrayList<Interval>();
		if(intervals.size()==0) {
			newlist.add(newInterval);
			return newlist;
		}
		if(newInterval.start<=intervals.get(0).start && newInterval.end>=intervals.get(intervals.size()-1).end) {
			newlist.add(newInterval);
			return newlist;
		}
		int i = 0;
		Interval curri;
		// Searching for start pos
		while(i<intervals.size()) {
			curri=intervals.get(i);
			if(newInterval.start<curri.start) {
				break;
			}
			else if(newInterval.start==curri.start) {
				break;
			}
			else if(newInterval.start>curri.start && newInterval.start<=curri.end) {
				newInterval.start = curri.start;
				break;
			}
			else {
				newlist.add(curri);
			}
			i++;
		}
		// searching for end pos
		while(i<intervals.size()) {
			curri=intervals.get(i);
			if(newInterval.end<curri.start) {
				break;
			}
			else if(newInterval.end==curri.start) {
				newInterval.end = curri.end;
				i++;
				break;
			}
			else if(newInterval.end>curri.start && newInterval.end<curri.end) {
				newInterval.end=curri.end;
				i++;
				break;
			}
			else {
				i++;
			}
		}
		newlist.add(newInterval);
		// adding remaining intervals
		while(i<intervals.size()) {
			newlist.add(intervals.get(i));
			i++;
		}
		return newlist;
	}
	public static void main(String[] args) {
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		List<Interval> l = new ArrayList<Interval>();
		l.add(i1);
		l.add(i2);
		l.add(i3);
		l.add(i4);
		l.add(i5);
		Interval newint = new Interval(4,9);
		System.out.println(insert(l,newint));
	}
}
