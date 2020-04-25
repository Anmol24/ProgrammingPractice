package com.anmol.service;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceCompare {

    /**
     * prepare s string builder and add the character to it if its not #. if it is # and string builder is not empty
     * then delete the last character inserted. Do this for both strings and compare the result at the end.
     *
     * You can do the same thing using stacks and compare the strings.
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        if(S== null && T == null || S.length() ==0 && T.length() == 0) return true;

        return backspaceStr(S).equals(backspaceStr(T));
    }

    private String backspaceStr(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == '#') {
                if(str.length()!=0) {
                    str.deleteCharAt(str.length()-1);
                }
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    private String compactStr(String s, char marker) {
        int index = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != marker) {
                /* Save character and move pointer forward
                    if backspace not encountered */
                chars[index] = chars[i];
                index++;
            }
            else if(index > 0) {
                /* Move pointer backwards if backspace encountered
                    and index is greater than zero */
                index--;
            }
        }
        /* String from character subarray */
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        BackspaceCompare compare = new BackspaceCompare();
        compare.backspaceCompare("a##b", "a#b");
        compare.compactStr("a#b#", '#');
        compare.compactStr("a#a##b#", '#');
        compare.compactStr("a#b", '#');
    }

}
