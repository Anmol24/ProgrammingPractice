package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    private final TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLastCharacter;

        public TrieNode() {
            children = new HashMap<>();
            isLastCharacter = false;
        }
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(word, root, 0);
    }

    public boolean dfsSearch(String word, TrieNode current, int index) {
        if(index == word.length()){
            return current.isLastCharacter;
        }

        char ch = word.charAt(index);
        if (current.children.containsKey(ch)) {
            if (index == word.length() - 1 && current.isLastCharacter) {
                return true;
            }

            return dfsSearch(word, current.children.get(ch), index + 1);
        } else if (ch == '.') {
            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                if (index == word.length() - 1 && current.isLastCharacter) {
                    return true;
                }
                if (dfsSearch(word, entry.getValue(), index + 1)) {
                    return true;
                }
            }
            return false;
        }
        return false;

    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
//        dictionary.addWord("bad");
//        dictionary.addWord("dad");
//        dictionary.addWord("mad");
//        System.out.println(dictionary.search("pad"));
//        System.out.println(dictionary.search("bad"));
//        System.out.println(dictionary.search(".ad"));
//        System.out.println(dictionary.search("b.."));
//        System.out.println(dictionary.search("m.d."));
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("a"));
        dictionary.addWord("bat");
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("an."));
        System.out.println(dictionary.search("a.d."));
        System.out.println(dictionary.search("b."));
        System.out.println(dictionary.search("a.d"));
        System.out.println(dictionary.search("."));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */