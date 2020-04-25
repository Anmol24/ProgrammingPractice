package com.anmol.service;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        if(intervals == null|| intervals.length<=1)return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval : intervals) {
            if(mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size()-1)[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.get(mergedIntervals.size()-1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size()-1)[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals intervals = new MergeIntervals();
        int[][] arr = new int[][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] mergeIntervals = intervals.mergeIntervals(arr);
        for(int[] interval : mergeIntervals) {
            System.out.println(interval[0] +" " + interval[1]);
        }
    }
}
