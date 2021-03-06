package com.anmol.service;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length == 1)return nums[0];
        int currMax = nums[0];
        int prevMax = 0;
        int max = currMax;
        for(int i = 1;i<nums.length-1;i++) {
            max = Math.max(nums[i] + prevMax, currMax);
            prevMax = currMax;
            currMax = max;
        }
        int exclude_1 = nums[1];
        int prevMax_1 = 0;
        int max_1 = exclude_1;
        for(int i = 2;i<nums.length;i++) {
            max_1 = Math.max(nums[i] + prevMax_1, exclude_1);
            prevMax_1 = exclude_1;
            exclude_1 = max_1;
        }
        return Math.max(max, max_1);
    }
}
