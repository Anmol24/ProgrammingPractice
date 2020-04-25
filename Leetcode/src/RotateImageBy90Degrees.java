package com.anmol.service;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 *
 *
 */
public class RotateImageBy90Degrees {

    /**
     * It is done in 2 steps, 1st step is to do the transpose of the matrix,
     *      [1,2,3],
     *  *   [4,5,6],
     *  *   [7,8,9]
     *
     *  transpose would give the array as
     *
     *      [1,4,7],
     *  *   [2,5,8],
     *  *   [3,6,9]
     *
     *  all left to do now is to swap the columns,
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // transpose
        for(int i = 0;i<matrix.length;i++) {
            for(int j = i+1;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int start = 0;
        int end = matrix[0].length-1;

        // swap the columns
        while (start<end) {
            for(int i =0;i<matrix.length;i++) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateImageBy90Degrees rotateImage = new RotateImageBy90Degrees();
        int[][] matrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotateImage.rotate(matrix);
        System.out.println("done");
    }
}
