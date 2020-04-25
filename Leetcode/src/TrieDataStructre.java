package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructre {

    private final TrieNode root;

    public TrieDataStructre() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.isLastCharacter = true;
    }

    public void delete(String word) {
        if(!search(word)) {
            throw new IllegalArgumentException();
        }


    }

    /**
     * Iterative implementation of search into trie.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.isLastCharacter;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLastCharacter;

        public TrieNode() {
            children = new HashMap<>();
            isLastCharacter = false;
        }
    }

    public static void main(String[] args) {
        TrieDataStructre trieDataStructre = new TrieDataStructre();
        trieDataStructre.insert("abc");
        trieDataStructre.insert("abcd");
        trieDataStructre.insert("abgl");
        trieDataStructre.insert("cdf");
        trieDataStructre.insert("lmn");

        System.out.println(trieDataStructre.search("ab"));
        System.out.println(trieDataStructre.search("abc"));
        System.out.println(trieDataStructre.search("abcv"));
        System.out.println(trieDataStructre.search("lmn"));
    }
}
