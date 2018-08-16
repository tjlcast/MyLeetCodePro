package com.tjlcast.Interview_Code.toutiao;

import java.util.Scanner;
import static java.lang.Math.max;

/**
 * @author by tangjialiang
 *         时间 2018/8/12.
 *         说明 游戏选牌
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        /**
         * dp[i][a][b] =    dp[i-1][a][b] no
         *                  dp[i-1][a+x[i]][b] + y[i]
         *                  dp[i-1][a][b+x[i]] + y[i]
         */
        int ans = 0;
        int[][] dp = new int[1000][1000];
        for (int i = 0; i < n; i++) {
            for (int a=0; a<1000; a++) {
                for (int b = 0; b < 1000; b++) {
                    int l1 = 0, l2 = 0;
                    if (a - x[i]>=0) l1 =  dp[a-x[i]][b] + y[i];
                    if (b - x[i]>=0) l2 =  dp[a][b-x[i]] + y[i];
                    int max = max(l1, l2);
                    dp[a][b] = max(max, dp[a][b]);
                    if (a == b) {
                        ans = max(ans, dp[a][b]);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

/**
 *
4
 3 1
 2 2
 1 4
 1 4
 **/