package com.anmol.service;

public class WallsAndGates {

    public void fillRooms(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int count) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < count) {
            return;
        }

        rooms[i][j] = count;
        dfs(rooms, i, j + 1, count + 1);
        dfs(rooms, i, j - 1, count + 1);
        dfs(rooms, i + 1, j, count + 1);
        dfs(rooms, i - 1, j, count + 1);
    }

    public static void main(String[] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();

        int[][] rooms = new int[][]{
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}

        };
        wallsAndGates.fillRooms(rooms);
    }
}
