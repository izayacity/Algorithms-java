package DP.LCS;

public class Main {
	public static void main(String[] args) {
		LCS lcs = new LCS();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X=s1.toCharArray();
		char[] Y=s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " +
				lcs.lcs( X, Y, m, n ) );
	}
}
