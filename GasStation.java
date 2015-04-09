package LeetCode;

import java.util.*;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int leftgas = 0;
		int start = 0;
	    for (int i = 0; i < 2*gas.length; ++i) {
	        leftgas += gas[i%gas.length] - cost[i%gas.length];
	        if (leftgas < 0) {
	            leftgas = 0;
	            start = i + 1;
	        }
	    }
	    if (start >= gas.length)
	        return -1;
	    return start;
	}
}
