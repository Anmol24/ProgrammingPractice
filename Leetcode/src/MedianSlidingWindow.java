package com.anmol.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
    PriorityQueue<Integer> lowerHalfMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> upperHalfMinHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        int start = 0;
        List<Double> list = new ArrayList<>();

        for(int i = 0; i< nums.length;i++) {
            if(lowerHalfMaxHeap.size() + upperHalfMinHeap.size() == k) {
                if(lowerHalfMaxHeap.contains(nums[start])) {
                    lowerHalfMaxHeap.remove(nums[start]);
                } else {
                    upperHalfMinHeap.remove(nums[start]);
                }
                start++;
            }
            balanceHeaps();
            if(lowerHalfMaxHeap.isEmpty() || nums[i] < lowerHalfMaxHeap.peek()) {
                lowerHalfMaxHeap.add(nums[i]);
            } else {
                upperHalfMinHeap.add(nums[i]);
            }
            balanceHeaps();
            if(lowerHalfMaxHeap.size() + upperHalfMinHeap.size() == k) {
                list.add(findMedian());
            }
        }
        double[] ans = new double[list.size()];
        int i = 0;
        for(double d : list) {
            ans[i++] = d;
        }
        return ans;
    }

    private void balanceHeaps() {
        if(Math.abs(lowerHalfMaxHeap.size() - upperHalfMinHeap.size()) >1) {
            if(lowerHalfMaxHeap.size() > upperHalfMinHeap.size()) {
                upperHalfMinHeap.add(lowerHalfMaxHeap.poll());
            } else {
                lowerHalfMaxHeap.add(upperHalfMinHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(lowerHalfMaxHeap.size() == upperHalfMinHeap.size()) {
            return ((double)lowerHalfMaxHeap.peek() + (double)upperHalfMinHeap.peek())/2;
        } else {
            return lowerHalfMaxHeap.size() > upperHalfMinHeap.size() ? lowerHalfMaxHeap.peek() : upperHalfMinHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianSlidingWindow slidingWindow = new MedianSlidingWindow();
        slidingWindow.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 2);
    }
}
