package com.anmol.service;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FirstAndLastIndex {

    /**
     * To solve this find the first starting index of the element do a binary search to find the element
     * and do a binary search again on the left to find the starting. Do the same thing to the right of the
     * index to find the end index
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] result = searchRange(new int[]{5,7,7,7,7,7,7,7,7,7,7,7,8,8,10}, 7);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[0];
        int start = 0;
        int end = nums.length-1;
        int startRange = getStartRange(nums, start, end, target, false);
        int endRange = getEndRange(nums, start, end, target, false);
        return new int[]{startRange, endRange};
    }

    public static int getStartRange(int arr[], int start, int end, int target, boolean found) {
        if(start>end) return -1;
        int mid = (start + end)/2;
        if(arr[mid] == target) {
            found = true;
            if(mid ==0) return 0;
            else if(arr[mid-1] !=target) {
                return mid;
            } else {
                return getStartRange(arr, start, mid-1, target, found);
            }
        } else if(arr[mid] >target) {
            end = mid-1;
            return getStartRange(arr, start, end, target,found);
        } else {
            start = mid+1;
            return getStartRange(arr, start, end, target,found);
        }



    }


    public static int getEndRange(int arr[], int start, int end, int target, boolean found) {
        if(start>end) return -1;
        int mid = (start + end)/2;
        if(arr[mid] == target) {
            found = true;
            if(mid ==arr.length-1) return mid;
            else if(arr[mid+1] !=target) {
                return mid;
            } else {
                return getEndRange(arr, mid+1, end, target,found);
            }
        } else if(arr[mid] >target) {
            end = mid-1;
            return getEndRange(arr, start, end, target,found);
        } else {
            start = mid+1;
            return getEndRange(arr, start, end, target,found);
        }


    }


}
