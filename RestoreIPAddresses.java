package LeetCode;

import java.util.*;
public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> ips = new ArrayList<String>();
		if(s.length()<4 || s.length()>12) return ips;
		String ip;
		switch (s.length()) {
			case 4:
				ip = s.charAt(0)+"."+s.charAt(1)+"."+s.charAt(2)+"."+s.charAt(3);
				ips.add(ip);
				break;
			case 5:
				int[] P1_5 = {1,1,1,2};
				int[] P2_5 = {2,2,3,3};
				int[] P3_5 = {3,4,4,4};
				for(int i=0;i<P1_5.length;i++) {
					String s1 = s.substring(0,P1_5[i]);
					String s2 = s.substring(P1_5[i],P2_5[i]);
					String s3 = s.substring(P2_5[i],P3_5[i]);
					String s4 = s.substring(P3_5[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 6:
				int[] P1_6 = {1,1,1,1,1,1,2,2,2,3};
				int[] P2_6 = {2,2,2,3,3,4,3,3,4,4};
				int[] P3_6 = {3,4,5,4,5,5,4,5,5,5};
				for(int i=0;i<P1_6.length;i++) {
					String s1 = s.substring(0,P1_6[i]);
					String s2 = s.substring(P1_6[i],P2_6[i]);
					String s3 = s.substring(P2_6[i],P3_6[i]);
					String s4 = s.substring(P3_6[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 7:
				int[] P1_7 = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3};
				int[] P2_7 = {2,2,3,3,3,4,4,3,3,3,4,4,5,4,4,5};
				int[] P3_7 = {4,5,4,5,6,5,6,4,5,6,5,6,6,5,6,6};
				for(int i=0;i<P1_7.length;i++) {
					String s1 = s.substring(0,P1_7[i]);
					String s2 = s.substring(P1_7[i],P2_7[i]);
					String s3 = s.substring(P2_7[i],P3_7[i]);
					String s4 = s.substring(P3_7[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 8:
				int[] P1_8 = {1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3};
				int[] P2_8 = {2,3,3,4,4,4,3,3,4,4,4,5,5,4,4,4,5,5,6};
				int[] P3_8 = {5,5,6,5,6,7,5,6,5,6,7,6,7,5,6,7,6,7,7};
				for(int i=0;i<P1_8.length;i++) {
					String s1 = s.substring(0,P1_8[i]);
					String s2 = s.substring(P1_8[i],P2_8[i]);
					String s3 = s.substring(P2_8[i],P3_8[i]);
					String s4 = s.substring(P3_8[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 9:
				int[] P1_9 = {1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3};
				int[] P2_9 = {3,4,4,3,4,4,5,5,5,4,4,5,5,5,6,6};
				int[] P3_9 = {6,6,7,6,6,7,6,7,8,6,7,6,7,8,7,8};
				for(int i=0;i<P1_9.length;i++) {
					String s1 = s.substring(0,P1_9[i]);
					String s2 = s.substring(P1_9[i],P2_9[i]);
					String s3 = s.substring(P2_9[i],P3_9[i]);
					String s4 = s.substring(P3_9[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 10:
				int[] P1_10 = {1,2,2,2,3,3,3,3,3,3};
				int[] P2_10 = {4,4,5,5,4,5,5,6,6,6};
				int[] P3_10 = {7,7,7,8,7,7,8,7,8,9};
				for(int i=0;i<P1_10.length;i++) {
					String s1 = s.substring(0,P1_10[i]);
					String s2 = s.substring(P1_10[i],P2_10[i]);
					String s3 = s.substring(P2_10[i],P3_10[i]);
					String s4 = s.substring(P3_10[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 11:
				int[] P1_11 = {2,3,3,3};
				int[] P2_11 = {5,5,6,6};
				int[] P3_11 = {8,8,8,9};
				for(int i=0;i<P1_11.length;i++) {
					String s1 = s.substring(0,P1_11[i]);
					String s2 = s.substring(P1_11[i],P2_11[i]);
					String s3 = s.substring(P2_11[i],P3_11[i]);
					String s4 = s.substring(P3_11[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
			case 12:
				int[] P1_12 = {3};
				int[] P2_12 = {6};
				int[] P3_12 = {9};
				for(int i=0;i<P1_12.length;i++) {
					String s1 = s.substring(0,P1_12[i]);
					String s2 = s.substring(P1_12[i],P2_12[i]);
					String s3 = s.substring(P2_12[i],P3_12[i]);
					String s4 = s.substring(P3_12[i]);
					if(Integer.valueOf(s1)<=255 && Integer.valueOf(s2)<=255 && Integer.valueOf(s3)<=255 && Integer.valueOf(s4)<=255
							&& !((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0') || (s3.length()>1 && s3.charAt(0)=='0') || (s4.length()>1 && s4.charAt(0)=='0'))) {
						ip = s1+"."+s2+"."+s3+"."+s4;
						ips.add(ip);
					}
				}
				break;
		}
		return ips;
	}
	public static void main(String[] args) {
		String s = "18188142188";
		System.out.println(restoreIpAddresses(s));
	}
}
