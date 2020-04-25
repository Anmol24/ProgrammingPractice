package com.anmol.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if(nums == null || nums.length ==0) return result;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i : nums) {
            sum+=i;
            if(map.containsKey(sum-k)) {
                result+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return result;

    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
//        subArraySum.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7);
        subArraySum.subarraySum(new int[]{3,3,7,3,-3,1,4,2}, 7);
    }
}
