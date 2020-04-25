package com.anmol.service;

import java.util.List;

interface BinaryMatrix {
    int get(int x, int y);

    List<Integer> dimensions();
}

public class LeftmostColumnWithAtleastOne {
    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     */

    public int leftMostColumnWithOne(BinaryMatrix matrix) {
        int ans = -1;

        List<Integer> dimension = matrix.dimensions();
        int row = dimension.get(0);
        int col = dimension.get(1);
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (matrix.get(i, j) == 1) {
                ans = j;
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
