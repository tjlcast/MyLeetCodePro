package com.tjlcast._8_array_and_metric;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/10/22.
 *         说明 在行列都排好的矩阵中找数
 */
public class Solution7 {
    /**
    7
    2 4
    4 4 4 8
    5 7 7 9
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        boolean work = work(data, target);
        System.out.println("ans: " + work);
    }

    private static boolean work(int[][] data, int target) {
        int rows = data.length;
        int cols = data[0].length;

        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (data[r][c] == target) {
                return true;
            } else if (data[r][c] > target) {
                c--;
            } else { // data[r][c] < target
                r++;
            }
        }

        return false;
    }

}
