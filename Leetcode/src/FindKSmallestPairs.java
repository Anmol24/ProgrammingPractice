package com.anmol.service;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class FindKSmallestPairs {

    /**
     * Create a min heap from the sum of the elements of two arrays, since arrays are sorted,
     * we know that the first element in the heap would be nums1[0]+ nums2[0]. add that will be the first item in result
     * to get the next item, add i+1,j and i,j+1 element in the queue and the minimum sum element would come on top as
     * we have a min heap, extract the indexes and add the corresponding elements to the answer result.
     */

    static class CustomPair implements Comparable {
        int sum;
        int index1;
        int index2;

        CustomPair(int sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public int compareTo(Object o) {
            return this.sum - ((CustomPair)o).sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
//        result.add(0,1);
        if(nums1 == null || nums2 == null) return result;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<CustomPair> queue = new PriorityQueue<>();

        queue.add(new CustomPair(nums1[0]+ nums2[0], 0, 0));
        visited.add(new Pair<>(0,0));
        Pair<Integer, Integer> temp;
        for(int len = 0; len<nums1.length*nums2.length && !queue.isEmpty();len++) {
            CustomPair pair = queue.poll();
            result.add(Arrays.asList(nums1[pair.index1], nums2[pair.index2]));
            if(result.size() == k) {
                return result;
            }
            int i = pair.index1;
            int j = pair.index2;

            if(i+1< nums1.length) {
                temp = new Pair<>(i+1, j);
                if(!visited.contains(temp)) {
                    queue.add(new CustomPair(nums1[i + 1] + nums2[j], i + 1, j));
                    visited.add(temp);
                }
            }
            if(j+1<nums2.length) {
                temp = new Pair<>(i, j+1);
                if(!visited.contains(temp)) {
                    queue.add(new CustomPair(nums1[i]+ nums2[j+1], i, j+1));
                    visited.add(temp);

                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        FindKSmallestPairs kSmallestPairs = new FindKSmallestPairs();
//        int[] nums1 = new int[]{1,7,11};
        int[] nums1 = new int[]{1,1,2};
//        int[] nums2 = new int[]{2,4,6};
        int[] nums2 = new int[]{1,2,3};
        List<List<Integer>> lists = kSmallestPairs.kSmallestPairs(nums1, nums2, 3);
        for(List<Integer> ls: lists) {
            System.out.println(ls.get(0) +" " + ls.get(1));
        }
    }
}
