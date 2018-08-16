package com.tjlcast.Interview_Code.wangyi;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/8/11.
 *         说明 小易的字典
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        int[] chars = new int[n+m];
        int idx = 0;
        for(int i=0; i<n; i++) {
            chars[idx++] = 'a'-'a';
        }
        for(int i=0; i<m; i++) {
            chars[idx++] = 'z'-'a';
        }

        for (int i=0; i<k-1; i++) {

            nextPermutation(chars);
        }
        print(chars);


    }

    public static void print(int[] chars) {
        for (int i=0; i<chars.length; i++) {
            System.out.print((char)(chars[i]+'a'));
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }

        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i);

        if(i >= 0){
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j);
            swap(nums,i,j - 1);
        }

        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--) {
            swap(nums, i, k);
        }
    }

    public static void swap(int[] array,int i ,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
