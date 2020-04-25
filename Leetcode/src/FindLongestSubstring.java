package com.anmol.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindLongestSubstring {

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }

    public static int findTheLongestSubstring(String s) {

        List<String> vowles = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        List<String> splitInputString = IntStream.range(0, s.length()).mapToObj(x -> String.valueOf(s.charAt(x))).collect(Collectors.toList());
        Map<Integer, Integer> maskToIndexMap = new HashMap<>();
        maskToIndexMap.put(0, -1);
        int mask = 0;
        int result = 0;
        for (int i = 0; i < splitInputString.size(); i++) {
            if (vowles.contains(splitInputString.get(i))) {
                mask = mask ^ (1 << vowles.indexOf(splitInputString.get(i)) + 1);
            }
            if (!maskToIndexMap.containsKey(mask)) {
                maskToIndexMap.put(mask, i);
            }
            result = Math.max(i - maskToIndexMap.get(mask), result);
        }
        return result;
    }
}
