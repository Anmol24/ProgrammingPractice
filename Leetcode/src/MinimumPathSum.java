package com.anmol.service;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        for(int i =1;i<grid.length;i++) {
            result[i][0] = result[i-1][0]+ grid[i][0];
        }
        for(int i =1;i<grid[0].length;i++) {
            result[0][i] = result[0][i-1] + grid[0][i];
        }
        for(int i =1;i<grid.length;i++) {
            for(int j = 1;j<grid[0].length;j++) {
                result[i][j] = grid[i][j] + Math.min(result[i-1][j], result[i][j-1]);
            }
        }
        return result[grid.length-1][grid[0].length-1];
    }
}
