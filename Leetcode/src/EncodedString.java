package com.anmol.service;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class EncodedString {

    static class EncodedNode {

        int count;
        String word;
        EncodedNode next;

        EncodedNode(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

    public String decodeString1(String input) {
        List<EncodedNode> list = new LinkedList<>();
        int len = 0;
        for(int i = 0; i<input.length();i++) {
            EncodedNode node= null;
            EncodedNode curr = null;
            if(Character.isDigit(input.charAt(i))) {
                len = len * 10 + Character.getNumericValue(input.charAt(i));
            } else if(input.charAt(i)=='[') {
                int j = i+1;
                StringBuilder sb = new StringBuilder();
                while (input.charAt(j) != ']') {
                    if(input.charAt(j)=='[') {
                        j++;
                        continue;
                    }
                    if (Character.isAlphabetic(input.charAt(j))) {
                        sb.append(input.charAt(j));
                    } else {
                        if (node == null) {
                            node = new EncodedNode(len, sb.toString());
                            curr = node;
                            len = Character.getNumericValue(input.charAt(j));
                            sb = new StringBuilder();
                        } else {
                            curr.next = new EncodedNode(len, sb.toString());
                            curr = curr.next;
                            len = Character.getNumericValue(input.charAt(j));
                        }
                    }
                    j++;
                }
                if (node == null) {
                    node = new EncodedNode(len, sb.toString());
                } else {
                    curr.next = new EncodedNode(len, sb.toString());
                }
                i = j;
                list.add(node);

            } else if(Character.isAlphabetic(input.charAt(i))) {
                node = new EncodedNode(1, input.substring(i, i+1));
                list.add(node);

            }
            len = 0;
        }
        StringBuilder result = new StringBuilder();
        for(EncodedNode node : list) {
            if(node.next == null) {
                for(int i =0;i<node.count;i++) {
                    result.append(node.word);
                }
            } else {
                result.append(getDecoded(node));
            }
        }
        return result.toString();
    }

    public String decodeString(String input) {
        StringBuilder sb = new StringBuilder();
        dfsHelper(input, sb, 0);
        return sb.toString();
    }

    private int dfsHelper(String input, StringBuilder sb, int index) {
        int len = 0;
        for(int i = index;i<input.length();i++) {
            if(Character.isDigit(input.charAt(i))) {
                len = len *10 + Character.getNumericValue(input.charAt(i));
            } else if(input.charAt(i) == '[') {
                StringBuilder nestedSB = new StringBuilder();
                int end = dfsHelper(input, nestedSB, i+1);
                while (len>0) {
                    sb.append(nestedSB);
                    len--;
                }
                len = 0;
                i = end;
            } else if(input.charAt(i) == ']') {
                return i;
            } else {
                sb.append(input.charAt(i));
            }
        }
        return 0;
    }

    private String getDecoded(EncodedNode node) {
        if(node == null) {
            return "";
        }

        node.word =  node.word + getDecoded(node.next);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<node.count;i++) {
            sb.append(node.word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EncodedString string = new EncodedString();
//        System.out.println(string.decodeString("100[anmol]"));
        System.out.println(string.decodeString("3[a2[c]]b"));
        System.out.println(string.decodeString1("3[a2[c]]"));
        System.out.println(string.decodeString1("3[a]2[bc]"));
        System.out.println(string.decodeString1("2[abc]3[cd]ef"));
        System.out.println(string.decodeString1("2[abc]3[cd]"));
        System.out.println(string.decodeString1("abcs"));
    }
}
