package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        //1011011 - 5, 2
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                count--;
            }
            if(map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return result;
    }
}
