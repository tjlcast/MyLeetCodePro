package com.tjlcast._8_array_and_metric;

/**
 * @author by tangjialiang
 *         时间 2018/10/14.
 *         说明 ...
 */
public class Solution1 {

    public static void main(String[] args) {
        int[][] datas = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        work(datas);
    }

    private static void work(int[][] datas) {
        int rows = datas.length;
        int cols = datas[0].length;

        boolean[][] isV = new boolean[rows][cols];
        int[] parsedDatas = new int[rows * cols];
        int d = 0;

        int r = 0;
        int c = 0;
        while (isValid(r, c, rows, cols, isV)) {
            parsedDatas[r*rows+c] = datas[r][c];
            isV[r][c] = true;

            if (!goBy(d, r, c, rows, cols, isV)) {
                d = (d+1)%4;
            }

            r = directs[d][0] + r;
            c = directs[d][1] + c;
        }

        for(Integer val : parsedDatas) {
            System.out.println(val);
        }
    }

    private static int[][] directs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    private static boolean goBy(int d, int r, int c, int rows, int cols, boolean[][] isV) {
        int newR = directs[d][0] + r;
        int newC = directs[d][1] + c;
        if (newR >= rows || newR < 0) {
            return false;
        }
        if (newC >= cols || newC < 0) {
            return false;
        }
        if (isV[newR][newC]) {
            return false;
        }
        return true;
    }

    private static boolean isValid(int r, int c, int rows, int cols, boolean[][] isV) {
        int newR = r;
        int newC = c;
        if (newC >= cols || newC < 0) {
            return false;
        }
        if (isV[newR][newC]) {
            return false;
        }
        return true;
    }
}
