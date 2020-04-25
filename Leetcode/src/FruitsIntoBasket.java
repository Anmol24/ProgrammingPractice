package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class FruitsIntoBasket {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int max = 0;
        while (j < tree.length) {
            if(map.size() <= 2) {
                map.put(tree[j], j++);
            }
            if (map.size() >= 3) {
                int min = Integer.MAX_VALUE;
                for (int val : map.values()) {
                    min = Math.min(val, min);
                }
                i = min + 1; // move i to the index of new starting that is the j.
                map.remove(tree[min]);

            }
            max = Math.max(max, j - i);

        }
        return max;

    }

    public int totalF1(int[] tree) {
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        while (i < tree.length) {
            while (j < tree.length && (map.containsKey(tree[j]) || map.size() < 2)) {
                map.put(tree[j], j);
                j++;
            }

            result = Math.max(result, j - i);

            int first_element_end = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < first_element_end) {
                    first_element_end = entry.getValue();
                }
            }
            map.remove(tree[first_element_end]);
            i = first_element_end + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FruitsIntoBasket basket = new FruitsIntoBasket();
//        System.out.println(basket.totalFruit(new int[]{0,1,6,6,4,4,6}));
//        System.out.println(basket.totalFruit(new int[]{1,2,3,2,2}));
//        System.out.println(basket.totalF1(new int[]{0, 0, 1, 1}));
        System.out.println(basket.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
//        System.out.println(basket.totalFruit(new int[]{0,1,2,2}));
    }
}



