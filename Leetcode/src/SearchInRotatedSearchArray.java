package com.anmol.service;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSearchArray {

    public int searchRotated(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length -1;
        while (start<end) {
            int mid = (start+end)/2;
            if(nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        int left = 0;
        int right = nums.length-1;
        if(target >=nums[start] && target <= nums[nums.length-1]) {
            left = start;
        } else {
            right = start;
        }
        while (left<=right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length-1;
        while(start <=end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] <= nums[mid]) {
                //[4,5,6,7,0,1,2]

                if(target >= nums[start] && target <= nums[mid]) {
                    end = mid -1;
                } else {
                    start = mid+1;
                }
            } else {
                // 4,5,6,7 --> 7,4,5,6
                // 4,5,6,7,8,1,2,3
                if (target > nums[start] && target > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSearchArray searchArray = new SearchInRotatedSearchArray();
        int[] nums = new int[]{6,7,0,1,2,3,4};
//        int[] nums = new int[]{4,5,6,7,8,1,2,3};
//        int target = 8;
        int target = 7;
//        searchArray.search(nums, target);

        searchArray.searchRotated(new int[]{1,3}, 3);
    }
}
