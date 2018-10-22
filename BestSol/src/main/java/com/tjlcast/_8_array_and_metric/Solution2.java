package com.tjlcast._8_array_and_metric;

/**
 * @author by tangjialiang
 *         时间 2018/10/15.
 *         说明 ...
 */
public class Solution2 {

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        printMatrix90(data);
    }

    private static void printMatrix90(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (i<j) {
                    int tmp = data[i][j];
                    data[i][j] = data[j][i];
                    data[j][i] = tmp;
                }
            }
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (j > cols/2) {
                    int tmp = data[i][j];
                    data[i][j] = data[i][cols-1-j];
                    data[i][cols-1-j] = tmp;
                }
            }
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
