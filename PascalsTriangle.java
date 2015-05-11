package LeetCode;

import java.util.*;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ptri = new ArrayList<List<Integer>>();
		if(numRows==0) return ptri;
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		ptri.add(row);
		for(int i=1;i<numRows;i++) {
			List<Integer> nrow = new ArrayList<Integer>();
			nrow.add(1);
			for(int j=1;j<i;j++) {
				nrow.add(ptri.get(i-1).get(j-1)+ptri.get(i-1).get(j));
			}
			nrow.add(1);
			ptri.add(nrow);
		}
		return ptri;
	}
}
