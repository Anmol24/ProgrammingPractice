package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int startI = 0;
        int startJ = 0;
        int endJ = matrix[0].length;
        int endI = matrix.length;

        int numElements = matrix.length * matrix[0].length;
        while(list.size() < numElements) {

            for(int i = startJ; i<endJ && list.size()<numElements ;i++) {
                list.add(matrix[startI][i]);
            }

            for(int i = startI+1;i<endI && list.size()<numElements;i++) {
                list.add(matrix[i][endJ-1]);
            }
            for(int i = endJ-2;i>=startJ && list.size()<numElements;i--) {
                list.add(matrix[endI-1][i]);
            }
            for(int i = endI-2;i>=startI+1 && list.size()<numElements;i--) {
                list.add(matrix[i][startJ]);
            }
            startI++;
            startJ++;
            endJ--;
            endI--;

        }
        return list;
    }

    public static void main(String[] args) {
        SpiralOrder order = new SpiralOrder();
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        order.spiralOrder(matrix);
    }
}
