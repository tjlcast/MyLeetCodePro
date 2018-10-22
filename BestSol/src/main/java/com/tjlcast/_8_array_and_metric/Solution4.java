package com.tjlcast._8_array_and_metric;

/**
 * @author by tangjialiang
 *         时间 2018/10/15.
 *         说明 ...
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -1, 7};
        int k = 3;

        workAndPrint(arr, k);
    }

    private static void workAndPrint(int[] arr, int k) {
        int[] work = work(arr, k);
        for (int i=1; i<work.length; i++) {
            System.out.println(work[i] + " ");
        }
    }

    private static int[] work(int[] arr, int k) {
        if (k < 1 || k > arr.length) return arr;

        int[] kHeap = new int[k+1];
        int i=0;
        for (; i<k; i++) {
            heapInsert(kHeap, arr[i], i+1);
        }

        for (; i<arr.length; i++) {
            if (arr[i] < kHeap[1]) {
                kHeap[1] = arr[i];
                headAdjust(kHeap);
            }
        }

        return kHeap;
    }

    /**
     * 向上调整
     * @param data
     * @param val
     * @param idx
     */
    private static void heapInsert(int[] data, int val, int idx) {
        data[idx] = val;
        while (idx > 0) {
            int parentIdx = idx/2;
            if (parentIdx > 0 && data[parentIdx] < data[idx]) {
                swap(data, idx, parentIdx);
            } else {
                break;
            }
        }
    }

    /**
     * 向下调整
     * @param data
     */
    private static void headAdjust(int[] data) {
        int idx = 1;

        while (idx < data.length) {
            int val = data[idx];

            int childIdx = idx*2;
            if (childIdx+1 < data.length && data[childIdx+1] < data[childIdx]) {
                childIdx++;
            }

            if (data[childIdx] < val) {
                swap(data, idx, childIdx);
            } else {
                break;
            }
            idx = childIdx;
        }
    }

    private static void swap(int[] data, int idx, int parentIdx) {
        int tmp = data[idx];
        data[idx] = data[parentIdx];
        data[parentIdx] = tmp;
    }
}
