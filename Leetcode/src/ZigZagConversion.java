package com.anmol.service;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.length()<=1 || numRows == 1) return s;
        StringBuilder[] result = new StringBuilder[numRows];
        boolean down = true;
        int j = 0;
        for(int i = 0;i <numRows;i++) {
            result[i] = new StringBuilder("");
        }
        for(int i = 0; i<s.length();i++) {
            result[j].append(s.substring(i,i+1));
            if(down) {
                j++;
            } else {
                j--;
            }
            if(j == numRows) {
                down = false;
                j = j-2;
            } else if (j == -1) {
                down = true;
                j = 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : result) {
            res.append(sb);
        }
        return res.toString();
    }
}
