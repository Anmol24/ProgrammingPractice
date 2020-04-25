package com.anmol.service;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        // Kth largest means after sort, K from right
        // if i have a priority queue/ heap(Min) of size k and go on filling
        // then it will only contain largest K and so leftmost will be kth largest
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();

    }

    public static void main(String[] args) {
        KthLargestElement element = new KthLargestElement();
        System.out.println(element.findKthLargest(new int[]{3,5,2,1,6,4},2));
    }
}
