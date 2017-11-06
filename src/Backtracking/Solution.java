package Backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int result = 0;
	int[] dp;

	public int combinationSum (int target) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		dp = new int[target + 1];
		backtrack(nums, target, 0);
		return result;
	}

	private boolean backtrack (int[] nums, int remain, int start) {
		if (remain < 0)	return false;
		else if (remain == 0) {
			result++;
			return true;
		} else {
			for (int i = start; i < nums.length; i++) {
				int tmp = remain - nums[i];

				if (dp[tmp] == 1)
					return true;
				else if (dp[tmp] == -1)
					return false;
				else {
					if(backtrack(nums, remain - nums[i], i)) {
						dp[tmp] = 1;
					} else {
						dp[tmp] = -1;
					}
					return dp[tmp] == 1;
				}
			}

		}
	}
}
