package com.anmol.service;

import javafx.util.Pair;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Set<Pair<Integer, Integer>> freshOranges = new LinkedHashSet<>();
        Queue<Pair<Integer, Integer>> rotten = new LinkedList<>();
        for(int i =0;i<grid.length;i++) {
            for(int j = 0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    rotten.add(new Pair<>(i,j));
                } else if(grid[i][j] == 1) {
                    freshOranges.add(new Pair<>(i,j));
                }
            }
        }
        int minutes = 0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        Pair<Integer, Integer> fresh;
        boolean found;
        while (freshOranges.size()>0) {
            int size = rotten.size();
            found = false;
            for(int i = 0;i<size;i++) {
                Pair<Integer, Integer> tempRotten = rotten.poll();
                for(int[] direction : directions) {
                    int i1 = direction[0] + tempRotten.getKey();
                    int i2 = direction[1] + tempRotten.getValue();
                    fresh = new Pair<>(i1, i2);
                    if(freshOranges.contains(fresh)) {
                        rotten.add(fresh);
                        found = true;
                        freshOranges.remove(fresh);
                    }
                }
            }
            if(!found) return -1;
            minutes++;
        }
        return minutes;
    }

    public static void main(String[] args) {

    }
}
