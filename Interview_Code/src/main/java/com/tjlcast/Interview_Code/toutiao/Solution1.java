package com.tjlcast.Interview_Code.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/8/12.
 *         说明 抖音关注
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] s = new int[N];
        int[] e = new int[N];
        Time[] times = new Time[N];

        for(int i=0; i<N; i++) {
            s[i] = scanner.nextInt();
            e[i] = scanner.nextInt();
            if (e[i] < s[i]) e[i] += M ; // todo
            times[i] = new Time(s[i], e[i]);
        }

        Arrays.sort(times);

        int n = 0;
        int beg = -1;
        int fin = -1;
        for (Time time : times) {
            int s1 = time.s;
            int e1 = time.e;

            if (s1 >= fin) {
                n++;
                fin = e1;
            }
        }

        for(Time time : times) {
            System.out.println(time);
        }

        System.out.println(n);
    }

    static class Time implements Comparable<Time> {
        int s;
        int e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (s == o.s) {
                return e - o.e;
            }
            return s - o.s;
        }

        @Override
        public String toString() {
            return s + "-"+e;
        }
    }
}

/*
3
10
0 3 3 7 7 0

3
10
0 5 2 7 6 9
 */
