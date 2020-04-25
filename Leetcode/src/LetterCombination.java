package com.anmol.service;

import java.util.*;

public class LetterCombination {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if(next_digits.length() == 0) {
            output.add(combination);
        } else {
            String startDigit = next_digits.substring(0, 1);
            String startLetters = phone.get(startDigit);
            for(int i = 0;i<startLetters.length();i++) {
                String letter = startLetters.substring(i,i+1);
                backtrack(combination+letter, next_digits.substring(1));
            }
        }


    }

    public List<String> letterCombinationsRecursive(String digits) {
        if(digits.length()>0) {
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
//        List<String> result = letterCombination.letterCombinationsRecursive("23");
        List<String> result = letterCombination.letterCombination("232");
        for(String st : result)
            System.out.println(st);
    }

    public List<String> letterCombination(String digits) {
        List<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if(word.length() == digits.length()) {
                result.add(word);
                continue;
            }

            String s = phone.get(digits.substring(word.length(), word.length()+1));
            if(s==null){
                return new ArrayList<>();
            }
            for(int i =0;i<s.length();i++) {
                queue.add(word+s.substring(i, i+1));
            }
        }
        return result;
    }
}
