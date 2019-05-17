package com.tjlcast._8_array_and_metric;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/10/22.
 *         说明 最长可整合子数组的长度
 */
public class Solution8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int num = sc.nextInt();
        int[] data = new int[num];

        for (int i=0; i<num; i++) {
            int d = sc.nextInt();
            data[i] = d;
        }

        int dataParsed = work(data);
        System.out.println(dataParsed);
    }

    private static int work(int[] arr) {
        int ans = Integer.MIN_VALUE;
        if (arr == null || arr.length==0) {
            return 0;
        }

        Arrays.sort(arr);
        int lastB = -1;
        int lastV = arr[0]-1;

        for (int i=0; i<arr.length; i++) {
            int n = arr[i];
            if (n - 1 == lastV) {

            } else {
                lastB = i;
            }
            ans = Math.max(ans, i - lastB+1);
            lastV = n;
        }

        return ans;
    }

    private static void test() {
        float a = 10f ;
        float b = 0.1f;

        float v = a % b;
        System.out.println(v);
    }
}
