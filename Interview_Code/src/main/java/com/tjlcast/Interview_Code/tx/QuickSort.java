package com.tjlcast.Interview_Code.tx;

/**
 * Created by tangjialiang on 2018/8/4.
 */
public class QuickSort {

    public void sort(int[] datas) {
        quickSort(datas, 0, datas.length-1);
    }

    private void quickSort(int[] datas, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = datas[left++];
        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && pivot<=datas[r]) {
                r--;
            }
            datas[l] = datas[r];
            while (l < r && pivot>=datas[l]) {
                l++;
            }
            datas[l] = pivot;
            quickSort(datas, left, l-1);
            quickSort(datas, l+1, right);
        }
    }

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(datas);

        for (Integer d : datas) {
            System.out.println(d);
        }
    }
}
