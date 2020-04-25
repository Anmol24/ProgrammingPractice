package com.anmol.service;

public class StringShift {
    public String stringShift(String s, int[][] shifts) {
        int left = 0;
        int right = 0;
        if(shifts == null || shifts.length == 0) return s;
        for(int[] shift : shifts) {
            if(shift[0] == 0) {
                left +=shift[1];
            } else {
                right +=shift[1];
            }
        }
        int moves = Math.abs(left-right) % s.length();
        if(moves == 0) return s;
        if(left> right) {
            return leftShift(s, moves);
        } else {
            return rightShift(s, moves);
        }

    }

    public String leftShift(String s, int moves) {
        StringBuilder sb = new StringBuilder();
        for(int i = moves;i<s.length();i++) {
            sb.append(s.charAt(i));
        }
        for(int i = 0;i<moves;i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String rightShift(String s, int moves) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-moves;i<s.length();i++) {
            sb.append(s.charAt(i));
        }
        for(int i = 0;i<s.length()-moves;i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringShift stringShift = new StringShift();
        int[][] shifts = new int[][]{{0,4},{0,5},{1,4},{1,5},{1,1}};
        System.out.println(stringShift.stringShift("mecsk", shifts));
    }
}
