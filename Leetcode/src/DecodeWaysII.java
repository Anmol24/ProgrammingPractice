package com.anmol.service;

public class DecodeWaysII {

    int M = 1000000007;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;

        for(int i =2;i<=s.length();i++) {
            char oneChar = s.charAt(i-1);
            char secondChar = s.charAt(i-2);
            if(oneChar == '*') {
                dp[i] = 9*dp[i-1];
                if(secondChar == '*') {
                    dp[i] = dp[i] + 15*dp[i-2];
                } else if(secondChar == '1') {
                    dp[i] = dp[i] + 9*dp[i-2];
                } else if(secondChar == '2') {
                    dp[i] = dp[i] + 6*dp[i-2];
                }
            } else {
                dp[i] = oneChar == '0' ? 0 :dp[i-1];
                if(secondChar == '1' || (secondChar =='2' && oneChar<='6')) {
                    dp[i] = dp[i] + dp[i-2];
                } else if(secondChar == '*') {
                    int val = oneChar<= '6'? 2:1;
                    dp[i] = dp[i] + val*dp[i-2];
                }
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWaysII decodeWaysII = new DecodeWaysII();
        decodeWaysII.numDecodings("1*1");
    }
}
