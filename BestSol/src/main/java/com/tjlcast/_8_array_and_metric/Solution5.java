package com.tjlcast._8_array_and_metric;

/**
 * @author by tangjialiang
 *         时间 2018/10/15.
 *         说明 ...
 */
public class Solution5 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};

        workAndPrint(arr);
    }

    private static void workAndPrint(int[] arr) {
        int minR = Integer.MAX_VALUE;
        int minRIdx = arr.length-1;
        int rIdx = arr.length - 1;
        for (; rIdx>=0; rIdx--) {
            if (arr[rIdx] < minR) {
                minR = arr[rIdx];
                minRIdx = rIdx;
            } else {
                minR = minRIdx;
                break;
            }
        }

        int maxL = Integer.MIN_VALUE;
        int maxLIdx = 0;
        int lIdx = 0;
        for (; lIdx<arr.length; lIdx++) {
            if (arr[lIdx] > maxL) {
                maxL = arr[lIdx];
                maxLIdx = lIdx;
            } else {
                maxL = maxLIdx;
                break;
            }
        }

        for (int i=maxL; i<=minR; i++) {
            System.out.println(arr[i] + " ");
        }
        if (maxL > minR) {
            System.out.println("error occurs.");
        }
    }


}
