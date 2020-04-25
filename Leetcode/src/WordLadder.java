package com.anmol.service;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level =1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                char[] curr = queue.poll().toCharArray();
                for(int j =0;j<curr.length;j++) {
                     char temp = curr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curr[j] = c;
                        String modified = new String(curr);
                        if (endWord.equals(modified)) {
                            return level + 1;
                        }
                        if (dict.contains(modified)) {
                            queue.add(modified);
                            dict.remove(modified);
                        }
                    }
                    curr[j]= temp;

                }
            }
            level++;
        }
        return 0;

    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        System.out.println(ladder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","log","lot","cog")));
    }
}
