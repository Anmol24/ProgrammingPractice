package com.anmol.service;

/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        String temp;
        int start = -1;
        int index = words.length-1;
        for(int i =0;i<words.length;i++) {
            if(words[i].equals("")) {
                start = i+1;
                while (start<words.length&& words[start].equals("")) {
                    start++;
                }
                if(start>=words.length) {
                    break;
                }
                temp = words[i];
                words[i] = words[start];
                words[start] = temp;
                index = i;
            }
        }
        for(int i=index;i>=0;i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);

    }

    public static void main(String[] args) {
//        String word = "  Hello is     World!   dada ";
//        String word = "the sky is blue";
        String word = "  ";
        ReverseWordsInString string = new ReverseWordsInString();
        System.out.println(string.reverseWords(word));
    }
}
