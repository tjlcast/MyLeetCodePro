package com.tjlcast._8_array_and_metric;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/10/19.
 *         说明 给定一个数组 arr，打印其中出现次数大于N/K的树
 *
 *         tips: 一吃删除的数量为K个不同的数字。直到最后剩下的数字。
 */
public class Solution6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] split = s.split(" ");
        int[] datas = new int[split.length];

    }

    /**
     * 一次在数组中删掉两个不同的数，不停的删除，直到剩下的数只有一种
     * 如果一个数出现次数大于一半，这个数一定会剩下来。
     * @param data
     * @return
     */
    private static int printHalfMajor(int[] data) {
        int cand = 0;
        int times = 0;

        for (int i=0; i<data.length; i++) {
            if (times == 0) {
                times = 1;
                cand = data[i];
            } else if (cand == data[i]) {
                times++;
            } else {
                times--;
            }
        }

        if (times < data.length/2) {
            return -1;
        }

        return cand;
    }
}
