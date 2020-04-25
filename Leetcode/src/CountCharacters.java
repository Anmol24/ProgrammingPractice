package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class CountCharacters {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"}; //act,bt,aht,tree;
        String chars = "atach"; //aacht
        System.out.println("characters formed are: " + countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        /**
         * Use a map to store the count of each character in chars, now iterate over words and get their count,
         * for each occurrence of character in words array the count should be same in chars map. if yes then the word
         * exists.
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<chars.length();i++) {
            if(map.containsKey(chars.charAt(i))) {
                map.put(chars.charAt(i), map.get(chars.charAt(i))+1);
            } else {
                map.put(chars.charAt(i),1);
            }
        }
        boolean found;
        int sum =0;
        for(String word: words) {
            found = true;
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int i = 0;i<word.length();i++) {
                if(temp.containsKey(word.charAt(i))) {
                    temp.put(word.charAt(i), temp.get(word.charAt(i))+1);
                } else {
                    temp.put(word.charAt(i),1);
                }
            }

            for(Map.Entry<Character, Integer> entry : temp.entrySet()) {
                if(!map.containsKey(entry.getKey()) || !(entry.getValue() <= (map.get(entry.getKey())))) {
                    found = false;
                    break;
                }
            }
            if(found) {
                sum += word.length();
            }
        }
        return sum;
    }
}
