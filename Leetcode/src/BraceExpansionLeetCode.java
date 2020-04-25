package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class BraceExpansionLeetCode {

    public List<String> braceExpansion(String str) {
        List<String> result = new ArrayList<>();
        List<String> expanded = new ArrayList<>();
        StringBuilder sb;
        for(int i = 0;i<str.length();i++) {
            sb = new StringBuilder();
            char ch = str.charAt(i);
            if(ch == '{') {
                int j = i+1;
                while (str.charAt(j)!='}') {
                    if(str.charAt(j)!=',') {
                        sb.append(str.charAt(j));
                    }
                    j++;

                }
                i=j;
                expanded.add(sb.toString());
            } else {
                expanded.add(sb.append(ch).toString());
            }
        }
        dfsHelper(expanded, result, 0, new StringBuilder());
        return result;
    }

    private void dfsHelper(List<String> expanded, List<String> result, int index, StringBuilder current) {
        if(index == expanded.size()) {
            result.add(current.toString());
            return;
        }
        for(char ch : expanded.get(index).toCharArray()) {
            current.append(ch);
            dfsHelper(expanded, result, index+1, current);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        BraceExpansionLeetCode expansionLeetCode = new BraceExpansionLeetCode();
        List<String> strings = expansionLeetCode.braceExpansion("{a,b,c}d{e,f}r");
        for(String st : strings) {
            System.out.println(st);
        }

    }

}
