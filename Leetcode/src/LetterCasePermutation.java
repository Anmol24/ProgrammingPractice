package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null || S.length() == 0) {
            result.add(S);
            return result;
        }

        char[] str = S.toCharArray();
        findPermutations(result, str, 0);
        return result;
    }

    public void findPermutations(List<String> result, char[] str, int index){
        result.add(new String(str));

        for(int i = index; i < str.length; i++){
            if(!Character.isDigit(str[i])){
                char temp = str[i];
                str[i] = (Character.isLowerCase(str[i])) ? Character.toUpperCase(str[i]) : Character.toLowerCase(str[i]);
                findPermutations(result, str, i + 1);
                str[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        LetterCasePermutation casePermutation = new LetterCasePermutation();
        casePermutation.letterCasePermutation("a1b2");
    }
}
