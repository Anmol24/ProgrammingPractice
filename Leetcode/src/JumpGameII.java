package com.anmol.service;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 *     [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
 */
public class JumpGameII {
    public static void main(String[] args) {
//        System.out.println(jump(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
//        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,2,1,0,4}));
    }

    /**
     * from each step i can go i+nums[i] jumps, keep going over the array and calculate the
     * maximum index that you can reach from current step by checking if maxTillNow < i + nums[i]
     * and move a step forward. If at anytime you can't move further that means you have to jump.
     * if by taking steps forward you reach to the lst index return jump.
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if(nums.length <=1) return 0;
        int steps = nums[0];
        int jump = 1;
        int maxReachableIndex = nums[0];

        for (int i = 1;i<nums.length;i++) {
            if(i == nums.length-1)
                return jump;
            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
            steps--; // move one step ahead;

            if(steps == 0) {
                jump++;
                if(i>=maxReachableIndex && nums[i]<=0) {
                    return -1;
                }
                steps = maxReachableIndex - i;
            }

        }
        return jump;
    }
}
