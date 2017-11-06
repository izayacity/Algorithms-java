package Backtracking;

public class Solution {

	int result = 0;
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
}
