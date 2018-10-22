package com.tjlcast.Interview_Code.tencent;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/9/16.
 *         说明 ...
 3
 91 16 5
 58 16 0
 96 12 4
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(work1(a, b, c)+"\n");
        }
    }

    private static String work(int a, int b, int c) {
        // (i % B) == c / A
        if (c % a ==0 && c/a <= b-1) {
            return "YES";
        }
        // (A % B) == c / i
        if ( a % b <= c) {
            return "YES";
        }
        return "NO";
    }

    private static String work1(int a, int b, int c) {
        HashSet<Integer> recorders = new HashSet<>();

        for(int i=1; ; i++) {
            if ((a*i)%b == c) {
                return "YES";
            }
            if (recorders.contains((a*i)%b)) {
                return "NO";
            }
            recorders.add((a*i)%b);
        }
    }
}
