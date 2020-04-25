package com.anmol.service;

import java.util.TreeMap;

public class IsPossibleDivide {

    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        while (!map.isEmpty()) {
            int firstVal = map.firstKey();
            for(int i = firstVal; i <firstVal+k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        IsPossibleDivide divide = new IsPossibleDivide();
        System.out.println(divide.isPossibleDivide(nums, k));
    }
}
