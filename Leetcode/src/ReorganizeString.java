package com.anmol.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i<S.length();i++) {
            countMap.put(S.charAt(i), countMap.getOrDefault(S.charAt(i), 0)+1);
        }
        StringBuilder result = new StringBuilder();

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return countMap.get(o2) - countMap.get(o1);
            }
        });
        queue.addAll(countMap.keySet());

        while (queue.size() > 1) {
            char top = queue.poll();
            char nextTop = queue.poll();
            result.append(top);
            result.append(nextTop);
            countMap.put(top, countMap.get(top)-1);
            countMap.put(nextTop, countMap.get(nextTop)-1);
            if(countMap.get(top)!=0) {
                queue.add(top);
            }
            if(countMap.get(nextTop)!=0) {
                queue.add(nextTop);
            }
        }
        if(queue.size()!=0) {
            char top = queue.poll();
            if(countMap.get(top)>1) {
                return "";
            } else {
                result.append(top);
            }
        }
        return result.toString();
    }
}
