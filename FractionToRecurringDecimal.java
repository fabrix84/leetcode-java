package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0) return "0";
		String decimal = "";
		long numlong = numerator;
		long denlong = denominator;
		if((numlong<0 && denlong>0)) {
			decimal+="-";
			numlong = Math.abs(numlong);
		}
		else if (numlong>0 && denlong<0) {
			decimal+="-";
			denlong=Math.abs(denlong);
		}
		else if(numlong<0 && denlong<0) {
			numlong = Math.abs(numlong);
			denlong=Math.abs(denlong);
		}
		if(numlong%denlong==0 && numlong>=denlong) {
			return decimal+(numlong/denlong);
		}
		long rest = 0;
		if(denlong>=numlong) {
			decimal+="0.";
			rest=(numlong%denlong)*10;
		}
		else {
			rest=(numlong%denlong)*10;
			numlong=numlong/denlong;
			decimal+=numlong+".";
		}
		Map<Long,Integer> dec = new HashMap<Long,Integer>();
		while(rest!=0) {
			numlong=rest/denlong;
			rest=(rest-(numlong*denlong))*10;
			decimal+=numlong;
			if(dec.containsKey(rest)) {
				int i = dec.get(rest);
				if(decimal.charAt(decimal.length()-1)==decimal.charAt(i-1)) {
					i--;
					decimal = decimal.substring(0,i)+"("+decimal.substring(i,decimal.length()-1)+")";
				}
				else {
					decimal = decimal.substring(0,i)+"("+decimal.substring(i)+")";
				}
				break;
			}
			dec.put(rest, decimal.length());
		}
		return decimal;
	}
	public static void main(String[] args) {
		Random r = new Random();
		int num;
		num = r.nextInt(100); num = -1;
		int den;
		den = r.nextInt(100); den = -2147483648;
		System.out.println(num+"/"+den+" = "+fractionToDecimal(num,den)+" = "+(num*1.0/den));
	}
}
