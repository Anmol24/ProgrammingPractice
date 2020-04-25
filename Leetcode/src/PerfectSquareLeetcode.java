package com.anmol.service;

import java.util.*;

public class PerfectSquareLeetcode {
    public int perfectSquares_BFS(int number) {
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        queue.add(-1);
        int sqrt = (int) Math.sqrt(number);
        int[] squares = new int[sqrt+1];
        for(int i = 1;i<=sqrt;i++) {
            squares[i] = i * i;
        }
        int level = 1;
        while (true) {
            int num = queue.poll();
            if(num == -1) {
                level++;
                queue.add(-1);
                continue;
            }
            for(int i = 1;i<squares.length;i++) {
                int remainder = num - squares[i];
                if(remainder == 0){
                    return level;
                }
                if(remainder>0 &&!visited.contains(remainder)) {
                    queue.add(remainder);
                    visited.add(remainder);
                }
            }
        }

    }

    public int perfectSquaresDP(int number) {
        int[] dp = new int[number+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <=number;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j<=i;j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j]+1);
            }
        }
        return dp[number];
    }
    public static void main(String[] args) {
        PerfectSquareLeetcode perfectSquareLeetcode = new PerfectSquareLeetcode();
        System.out.println(perfectSquareLeetcode.perfectSquaresDP(13));
        System.out.println(perfectSquareLeetcode.perfectSquares_BFS(7));
    }
}
