package DP.Knapsack;

// https://www.geeksforgeeks.org/knapsack-problem/
public class Knapsack {
	// O(nW) where n is the number of items and W is the capacity of knapsack.
	int knapSack(int W, int wt[], int val[], int n) {
		int dp[][] = new int[n + 1][W + 1];

		for(int i = 0; i <= n; i++) {
			for(int w = 0; w <= W; w++) {
				if(i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if (wt[i - 1] > w) {
					dp[i][w] = dp[i - 1][w];		// i th item not included
				} else {
					dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
				}
			}
		}
		return dp[n][W];
	}

	// Time complexity of this naive recursive solution is exponential (2^n).
	int knapSackNaive(int W, int wt[], int val[], int n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		if(wt[n - 1] > W) {
			return knapSackNaive(W, wt, val, n - 1);
		}
		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		return Math.max(val[n - 1] + knapSackNaive(W - wt[n - 1], wt, val, n - 1),
				knapSackNaive(W, wt, val, n - 1));
	}
}
