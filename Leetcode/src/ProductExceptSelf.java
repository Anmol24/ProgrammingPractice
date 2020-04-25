package com.anmol.service;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums== null || nums.length<=1) {
            return nums;
        }
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1;i<left.length;i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        int[] right = new int[nums.length];
        right[right.length-1] = 1;
        for(int i = right.length-2;i>=0;i--) {
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++ ) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] result = productExceptSelf.productExceptSelf(nums);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
