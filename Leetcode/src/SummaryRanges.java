package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {

    public static void main(String[] args) {
        List<String> summaries = summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        for (String summary : summaries) {
            System.out.println(summary);
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                result.add(getSummaryRange(start, nums[i - 1]));
                start = nums[i];
            }
        }

        result.add(getSummaryRange(start, nums[nums.length - 1]));
        return result;
    }

    private static String getSummaryRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
