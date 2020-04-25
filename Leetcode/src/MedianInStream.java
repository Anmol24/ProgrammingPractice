package com.anmol.service;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInStream {

    /**
     * we need to maintain two heaps, one is max heap and one is min heap.
     * the max heap would be for the lower half of the elements
     * and min heap for the upper half.
     * i.e. if elements are 1,2,3,4,5,6
     * the max heap would have elements 1 2 3 in a max heap for lower half.
     * and min heap will have elements 4,5,6 in a min heap for upper half.
     * since the elements are added in stream.
     *
     * if the max heap is empty or the element is less than the max heap peek then add it to the lower half
     * else add it to the min heap.
     * if after adding the element, the difference in heap size is greater than 1 then balance the heap by
     * moving the element from bigger heap to the smaller.
     *
     * once it is done, if total number is odd, then return the first elemetn from the bigger heap. i.e. max from
     * max heap or min from min heap. else do an average of those 2
     *
     */
    PriorityQueue<Integer> lowerHalfMaxHeap;
    PriorityQueue<Integer> upperHalfMinHeap;

    public MedianInStream() {
        lowerHalfMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        upperHalfMinHeap = new PriorityQueue<>();
    }

    public void addNumber(int number) {
        if(lowerHalfMaxHeap.isEmpty() || number<lowerHalfMaxHeap.peek()) {
            lowerHalfMaxHeap.add(number);
        } else {
            upperHalfMinHeap.add(number);
        }
        balanceHeaps(lowerHalfMaxHeap, upperHalfMinHeap);
    }

    private void balanceHeaps(PriorityQueue<Integer> lowerHalfMaxHeap, PriorityQueue<Integer> upperHalfMinHeap) {
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
            return (lowerHalfMaxHeap.peek() + upperHalfMinHeap.peek())/2.0;
        } else {
            return lowerHalfMaxHeap.size() > upperHalfMinHeap.size() ? lowerHalfMaxHeap.peek() : upperHalfMinHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianInStream median = new MedianInStream();
        median.addNumber(23);
        median.addNumber(13);
        median.addNumber(53);
        median.addNumber(34);
        median.addNumber(3);
        median.addNumber(18);
        System.out.println(median.findMedian());
    }

}
