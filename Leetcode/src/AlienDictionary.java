package com.anmol.service;

import java.util.HashMap;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> index = new HashMap<>();

        for(int i =0;i<order.length();i++) {
            index.put(order.charAt(i), i);
        }

        for(int i = 0; i<words.length;i++) {
            for(int j = i+1;j<words.length;j++) {
                int min = Math.min(words[i].length(), words[j].length());
                for(int k = 0; k<min;k++) {
                    char iCh = words[i].charAt(k);
                    char jCh = words[j].charAt(k);
                    if(index.get(iCh) < index.get(jCh)) {
                        break;
                    } else if(index.get(iCh) > index.get(jCh)) {
                        return false;
                    } else if(k == min-1 && words[i].length() > words[j].length()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        AlienDictionary dictionary = new AlienDictionary();
        String[] words = new String[]{"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(dictionary.isAlienSorted(words, order));
    }
}
