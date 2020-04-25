package com.anmol.service;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums) {
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        // init heap 'the less frequent element first'
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // keep k top frequent elements in the heap
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(heap.size() <k) {
                heap.add(entry);
            } else {
                if(entry.getValue() > heap.peek().getValue()) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }

        // build output list
        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty())
            top_k.add(heap.poll().getKey());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        TopKFrequentElements frequentElements = new TopKFrequentElements();
//        frequentElements.topKFrequent(new int[]{1,1,1,2,2,3,4,4,4,5,5,5,5}, 2);
        frequentElements.topKFrequent(new int[]{1,1,1,4,4,4,4,2,2,3}, 2);
    }
}
