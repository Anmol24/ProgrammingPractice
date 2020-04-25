package com.anmol.service;

/**
 *
 */
public class ShortestWaysToFormString {

    public int waysToFormString(String source, String destination) {
        int numSequence = 0;
        String remainingSequence = destination;
        while (remainingSequence.length()>0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i<source.length() && j<remainingSequence.length()) {
                if (source.charAt(i) == remainingSequence.charAt(j)) {
                    sb.append(remainingSequence.charAt(j));
                    j++;
                }
                i++;
            }
            if(sb.length() == 0) {
                return -1;
            }
            numSequence++;
            remainingSequence = remainingSequence.substring(sb.length());

        }
        return numSequence;
    }

    public static void main(String[] args) {
        ShortestWaysToFormString waysToFormString = new ShortestWaysToFormString();
        System.out.println(waysToFormString.waysToFormString("abc", "abcdbc"));
        System.out.println(waysToFormString.waysToFormString("abc", "abcbc"));
        System.out.println(waysToFormString.waysToFormString("xyz", "zxyyxz"));
    }
}
