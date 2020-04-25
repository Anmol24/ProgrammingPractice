package com.anmol.service;

import java.util.LinkedList;
import java.util.Queue;

public class Update01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        if(matrix == null) return matrix;

        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = new int[][]{{0,-1}, {-1,0},{0,1},{1,0}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for(int[] dir : directions) {
                int r = row+dir[0];
                int c = col + dir[1];
                if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length) {
                    continue;
                }
                if(matrix[r][c]!=0 && (matrix[r][c] > 1 + matrix[row][col])) {
                    matrix[r][c] = matrix[row][col]+1;
                    queue.add(new int[]{r,c});
                }
            }

        }
        return matrix;

    }

    public static void main(String[] args) {
        int[][]  matrix = new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        Update01Matrix update01Matrix = new Update01Matrix();
        update01Matrix.updateMatrix(matrix);
    }
}
