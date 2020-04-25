package com.anmol.service;

public class MinimumSubArraySizeSum {

    public static void main(String[] args) {
        // s = 7, nums = [2,3,1,2,4,3]
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums[0] == s) return 0;
        int firstIndex = 0;
        int sum = nums[firstIndex];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum == s) {
                min = Math.min(min, i - firstIndex);
            }
            while (sum > s) {
                sum = sum - nums[firstIndex++];
            }
            if (sum == s) {
                min = Math.min(min, i - firstIndex);
            }

        }
        return min +1;
    }
}
