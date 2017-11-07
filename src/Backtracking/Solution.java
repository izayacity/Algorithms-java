package Backtracking;

public class Solution {

	int result = 0;
	long dp[] = new long[611];
//Problem: Imagine you are playing a board game. You roll a 6-faced dice
//and move forward the same number of spaces that you rolled.
//If the finishing point is “n” spaces away from the starting point,
//please implement a program that calculates how many possible ways
//there are to arrive exactly at the finishing point? If n=610,
//How many possible ways are there to arrive exactly at the finishing point?
//(My answer is 1064412205 excuted in JVM)
	public int combinationSum (int target) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		backtrack(nums, target, 0);
		return result;
	}

	private void backtrack (int[] nums, int remain, int start) {
		if (remain < 0)	return;
		else if (remain == 0) {
			result++;
		} else {
			for (int i = start; i < nums.length; i++) {
				backtrack(nums, remain - nums[i], i);
			}
		}
	}

	public long combinationSumDP (int target) {
		for (int i = 1; i <= target; i++) {
			long tmp = 0;

			for (int j = 1; j <= 6; j++) {
				if (i == j)
					tmp++;
				if (i > j)
					tmp += dp[i - j];
			}
			dp[i] = tmp;
		}
		return dp[target];
	}

	public int combinationSumDTM (int target) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		return backtrack_new(nums, target, 5);
	}

	private int backtrack_new (int[] nums, int remain, int kinds) {
		if (remain < 0)	return 0;
		if (remain == 0) return 1;
		if (kinds < 0) return 0;
		else return backtrack_new(nums, remain, kinds - 1) + backtrack_new(nums, remain - nums[kinds], kinds);
	}

	public long combinationSumDP2 (int target) {
		long[] dp = new long[target + 1];
		return backtrack_DP2(target, dp);
	}

	private long backtrack_DP2 (int remain, long dp[]) {
		if (remain == 0) {
			return 0;
		}
		if (dp[remain] == 0) {
			for (int j = 1; j <= 6; j++) {
				if (remain == j)
					dp[remain]++;
				else if (remain > j)
					dp[remain] += backtrack_DP2(remain - j, dp);
			}
		}
		return dp[remain];
	}
}
