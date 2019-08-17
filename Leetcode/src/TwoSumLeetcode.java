/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetcode {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int result[] = printTwoSum(nums, 9);
        System.out.println("Result: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * keep a track of number and the index in a map. and next time if target - number exists in the map that means that
     * we have a valid sum. In that case just return the current and stored index in the map as the result.
     *
     * @param nums   input array
     * @param target target sum to find
     * @return the actual array of indices.
     */
    private static int[] printTwoSum(int[] nums, int target) {
        if (nums.length <= 1) return new int[0];
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
