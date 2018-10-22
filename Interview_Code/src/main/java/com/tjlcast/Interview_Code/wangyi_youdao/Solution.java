package com.tjlcast.Interview_Code.wangyi_youdao;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/9/28.
 *         说明 ...
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();

        for (long i=1; i<n/2; i++) {
            long count = 0;
            long total = n;
            while (true) {
                total -= i;
                if (total <= 0) break;
                count += i;
                total -= (total /10);
                if (total <= 0) break;
            }
            if (count > n/2) {
                System.out.println(i);
                break;
            }
        }
    }
}
