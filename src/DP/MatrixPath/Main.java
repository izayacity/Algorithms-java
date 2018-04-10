package DP.MatrixPath;

public class Main {
	public static void main (String[] args) {
		int  matrix[][] = { {1, 2, 9},
				{5, 3, 8},
				{4, 6, 7} };
		MatrixPath mp = new MatrixPath();
		System.out.println("Length of the longest path is " +
				mp.longestOverall(matrix));
	}
}
