package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

public class SubsetOfArray {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        generateSubsets(nums, 0, subset, new ArrayList<Integer>());
        return subset;
    }

    private void generateSubsets(int[] nums, int index, List<List<Integer>> subset, ArrayList<Integer> current) {
        subset.add(new ArrayList<>(current));
        for(int i = index; i<nums.length;i++) {
            current.add(nums[i]);
            generateSubsets(nums, i+1, subset, current);
            current.remove(current.size()-1);
        }
    }


    public static void main(String[] args) {
        SubsetOfArray subsetOfArray = new SubsetOfArray();
        subsetOfArray.powerSet(new int[]{1,2,3});
    }

}
