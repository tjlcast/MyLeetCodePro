package com.tjlcast.Interview_Code.zhongkeyuan;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/10/12.
 *         说明 ...
 */

/**
 1
 18 13
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i=0; i<t; i++) {
            // in
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            int y=0;

            // work
            int count = 0;
            for (; ;y++) {
                if (count == k) break;
                if (isValid(x, y)) {
                    count++;
                }
            }

            // out
            System.out.println(y);
        }
    }

    private static boolean isValid(int x, int y) {
        return (x+y) == (x|y);
    }
}
