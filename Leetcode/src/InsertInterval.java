package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals == null || intervals.length <=0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }
        // the interval to be added comes after the current one and is non overlapping
        for (int[] interval : intervals) {
            //case 1 - new interval is non-overlapping and comes after the current one
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // case 2 - new interval is non -overlapping and comes before the current one.
                result.add(newInterval);
                newInterval = interval;
            } else {
                // else we need to merge the intervals and find  the new interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] arr = new int[][] {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };

        int[] newInterval = new int[]{4,9};
        insertInterval.insert(arr, newInterval);
    }
}
