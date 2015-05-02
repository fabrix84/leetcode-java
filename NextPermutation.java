package LeetCode;

import java.util.Arrays;
import java.util.*;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int len = num.length;
		int k=-1;
		int l=-1;
		//step1
		for (int i=0;i<len-1;i++){
			if (num[i]<num[i+1]){
				k=i;
			}
		}
		if (k==-1){
			Arrays.sort(num);
			return;
		}
		//step2
		for (int i=k+1;i<len;i++){
			if (num[i]>num[k]){
				l=i;
			}
		}
		//step3
		int tmp = num[l];
		num[l]=num[k];
		num[k]=tmp;
		//step4
		for(int start=k+1, end=num.length-1; start<=end; start++, end--){
			int aux = num[start];
			num[start]=num[end];
			num[end]=aux;
		}
	}
}
