package com.tjlcast.Interview_Code.wangyi;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author by tangjialiang
 *         时间 2018/8/11.
 *         说明 丰收
 *         
 */
public class Solution2 {

    private static TreeMap<Integer, Integer> poss = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] a = new int[n];

        int no = 0;
        for(int i=0; i<n; i++) {
            a[i] = scan.nextInt();
            poss.put(a[i]+no, i+1);
            no += a[i]; 
        }

        int m = scan.nextInt();
        for(int i=0; i<m; i++) {
            Map.Entry<Integer, Integer> integerIntegerEntry = poss.ceilingEntry(scan.nextInt());
            if (integerIntegerEntry == null) {
                System.out.println(n);
            } else {
                System.out.println(integerIntegerEntry.getValue());
            }
        }
    }
}



