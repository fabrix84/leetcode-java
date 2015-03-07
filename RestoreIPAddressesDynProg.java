package LeetCode;

import java.util.*;
public class RestoreIPAddressesDynProg {
	public static boolean isValid(String s) {
		if(s.length()>0) {
			int sn = Integer.valueOf(s);
			return (s.charAt(0)=='0' && s.length()>1 || sn>255)?false:true;
		}
		return false;
	}
	public static List<String> restoreIpAddresses(String s) {
		if(s.length()<4 || s.length()>12) return new ArrayList<String>();
		List<String> ips = restoreIP(s,3);
		return ips;
	}
	public static List<String> restoreIP(String s, int remaining) {
		List<String> ips = new ArrayList<String>();
		if(remaining==0) {
			if(isValid(s)) ips.add(s);
		}
		else {
			for(int i=1;i<=3;i++) {
				if(i<s.length()) {
					String token = s.substring(0,i);
					if(isValid(token)) {
						for(String iptoken: restoreIP(s.substring(i),remaining-1)) {
							String ip = token+"."+iptoken;
							ips.add(ip);
						}
					}
				}
			}
		}
		return ips;
	}
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}
}
