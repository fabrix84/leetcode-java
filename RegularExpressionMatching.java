package LeetCode;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		int[][] cached = new int[s.length()+1][p.length()+1];
		return isMatchRec(s,0,p,0,cached);
	}
	public static boolean isMatchRec(String s, int i, String p, int j, int[][] cached) {
		if(cached[i][j]==1) return true;
		if(cached[i][j]==2) return false;
		if(s.length()-i==0 && p.length()-j==0) {
			cached[i][j]=1;
			return true;
		}
		else if(s.length()-i>0 && p.length()-j==0) {
			cached[i][j]=2;
			return false;
		}
		else if(s.length()-i==0) {
			if(j<p.length()-1 && p.charAt(j+1)=='*') {
				cached[i][j]=(isMatchRec(s,i,p,j+2, cached))?1:2;
				return cached[i][j]==1;
			}
			if(j<p.length() && p.charAt(j)!='*') {
				cached[i][j]=2;
				return false;
			}
			else {
				cached[i][j] = (isMatchRec(s,i,p,j+1, cached))?1:2;
				return cached[i][j]==1;
			}
		}
		else if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.') {
			if((j<p.length()-1 && p.charAt(j+1)!='*') || j==p.length()-1) {
				cached[i][j]=(isMatchRec(s,i+1,p,j+1, cached))?1:2;
				return cached[i][j]==1;
			}
			else {
				cached[i][j] = (isMatchRec(s,i+1,p,j,cached) || isMatchRec(s,i+1,p,j+1,cached) || isMatchRec(s,i+1,p,j+2,cached)
				|| isMatchRec(s,i,p,j+2,cached))?1:2;
				return cached[i][j]==1;
			}
		}
		else if(p.charAt(j)=='*' && (s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.')) {
			cached[i][j] = (isMatchRec(s,i+1,p,j+1,cached) || isMatchRec(s,i+1,p,j,cached))?1:2; 
			return cached[i][j]==1;
		}
		else if(j<p.length()-1 && s.charAt(i)!=p.charAt(j) && p.charAt(j+1)=='*') {
			cached[i][j] = (isMatchRec(s,i,p,j+2,cached))?1:2;
			return cached[i][j]==1;
		}
		cached[i][j]=2;
		return false;
	}
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaab";
		String p = "a*a*a*a*a*a*a*a*a*a*c";
		System.out.println(isMatch(s,p));
	}
}
