package com.anmol.service;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
    }

    public static String longestPalindromicSubstring(String s) {
        if(s==null || s.length()<=1) return s;
        boolean[][] result = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++) {
            result[i][i] = true;
        }
        String longestPalindrome = String.valueOf(s.charAt(0));
        for(int len = 2;len<=s.length();len++) {
            for(int i = 0;i<=s.length() -len;i++) {
                int j = len + i - 1;
                if(len == 2) {
                    if(s.charAt(i) == s.charAt(j)) {
                        result[i][j] = true;
                        longestPalindrome = s.substring(i, j+1);
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && result[i+1][j-1]) {
                        result[i][j] = true;
                        longestPalindrome = longestPalindrome.length() < s.substring(i, j+1).length() ? s.substring(i, j+1) : longestPalindrome;
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
