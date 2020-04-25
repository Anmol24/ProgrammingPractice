package com.anmol.service;

import java.util.*;

public class LargestValuesFromLable {

    static class LabeledValue {
        int label;
        int value;

        LabeledValue(int label, int value) {
            this.label = label;
            this.value = value;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<LabeledValue> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for(int i =0 ;i< values.length;i++) {
            queue.add(new LabeledValue(labels[i], values[i]));
        }


        Map<Integer, Integer> usedLabel = new HashMap<>();
        int count = 0;
        int max = 0;
        while (count < num_wanted && !queue.isEmpty()) {
            LabeledValue labeledValue = queue.poll();
            if(usedLabel.getOrDefault(labeledValue.label, 0) < use_limit) {
                max += labeledValue.value;
                usedLabel.compute(labeledValue.label, (k, v)-> {
                    if(v == null) {
                        return 1;
                    }
                    return v +1;
                });
                count++;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        LargestValuesFromLable lable = new LargestValuesFromLable();
        int[] values = new int[]{5,4,3,2,1};
        int[] labels = new int[]{1,1,2,2,3};

        int num_wanted = 3;
        int use_limit = 1;
        System.out.println(lable.largestValsFromLabels(values, labels, num_wanted, use_limit));
    }
}
