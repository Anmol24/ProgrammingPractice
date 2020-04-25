package com.anmol.service;

public class SurroundedRegions {

    public void solve(char[][] grid) {
        if(grid == null || grid.length <=1) return;

        int rows = grid.length;
        int columns = grid[0].length;

        // first go over the first and last element in each row and mark them safe
        // as they won't be surrounded
        for(int i = 0;i<rows;i++) {
            if(grid[i][0] == 'O') {
                dfs(grid, i, 0);
            }
            if(grid[i][columns-1] == 'O') {
                dfs(grid, i, columns-1);
            }
        }
        for(int j = 0; j< columns;j++) {
            if(grid[0][j] == 'O') dfs(grid, 0,j);
            if(grid[rows-1][j]=='O') dfs(grid, rows-1, j);
        }

        for(int i = 0;i<rows;i++) {
            for(int j = 0; j<columns;j++) {
                if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if(grid[i][j] == '*') {
                    grid[i][j] = 'O';
                }
            }
        }


    }

    public void dfs(char[][] grid, int i, int j) {
        if(i<0|| i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!='O') {
            return;
        }
        if(grid[i][j] == 'O') grid[i][j] = '*';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);


    }
}
