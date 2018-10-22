package com.tjlcast.Interview_Code.tencent;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/9/16.
 *         说明 ...
 4 3
 2 1
 3 2
 4 3
 */
public class Solution2 {
    static int[][] graph;
    static HashSet[] in;
    static HashSet[] out;

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n][n];
        in = new HashSet[n];
        out = new HashSet[n];
        for (int i=0; i<n; i++) {
            in[i] = new HashSet();
            out[i] = new HashSet();
        }

        for (int i=0; i<m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u-1][v-1] = 1;
        }
        work();

        int total=0;
        for(int i=0; i<n; i++) {
            if (in[i].size() > out[i].size()) {
                total++;
            }
        }
        System.out.println(total);
    }

    private static void work() {
        for (int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i==j) {continue;}
                    if ((graph[i][k]==1 && graph[k][j]==1)) {graph[i][j] = 1;}
                    if (graph[i][j]==1) {
                        out[i].add(j);
                        in[j].add(i);
                    }
                }
            }
        }
    }
}
