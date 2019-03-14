package Backtracking;

import java.util.Arrays;

public class Solution {

//Problem: Imagine you are playing a board game. You roll a 6-faced dice
//and move forward the same number of spaces that you rolled.
//If the finishing point is “n” spaces away from the starting point,
//please implement a program that calculates how many possible ways
//there are to arrive exactly at the finishing point? If n=610,
//How many possible ways are there to arrive exactly at the finishing point?
    public long rollDice(int target) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        long[] dp = new long[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return rollDiceUtil(nums, target, 0, dp);
    }

    private long rollDiceUtil(int[] nums, int remain, int start, long[] dp) {
        if (remain < 0 || start == nums.length || nums[start] > remain) {
            return 0;
        }
        if (remain == 0 || nums[start] == remain) {
            return 1;
        }
        if (dp[remain] != -1) {
            return dp[remain];
        }
        return dp[remain] = rollDiceUtil(nums, remain - nums[start], start, dp) + rollDiceUtil(nums, remain, start + 1, dp);
    }

}
