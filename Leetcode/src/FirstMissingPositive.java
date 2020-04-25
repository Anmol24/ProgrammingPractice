package com.anmol.service;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;

        /**
         * if the element is negative, 0 or is greater than the length of the array then mark the element
         * as a special value such as nums.length+1
         */
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = nums.length + 1;

        /**
         * iterate on the array again, and if the element is not equal to nums.length+1
         * then mark the element at a[a[i]-1] as -negative.
         */
        for (int i = 0; i < nums.length; i++)
            if (Math.abs(nums[i]) != nums.length + 1) {
                int index = Math.abs(nums[i]) - 1;
                nums[index] = -1 * Math.abs(nums[index]);
            }
        /**
         * iterate on the array again, first positive element will tell the first missing positive
         * if no positive element like, for the case {1,2,3} the array would be {-1,-2,-3} that means the
         * element nums.length+1 was the first missing positive
         */
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                return i + 1;

        return nums.length + 1;
    }
}
