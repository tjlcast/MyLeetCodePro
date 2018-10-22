package com.tjlcast.Interview_Code.mi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/9/20.
 *         说明 ...
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        while(true) {
            String s = scanner.nextLine();

            if ("END".equals(s)) {
                break;
            }
            list.add(s);
        }
        new Solution1().work(list);
    }

    public void work(List<String> arr) {
        int count = 0;
        for (int i=0; i<arr.size(); i++) {
            boolean flag = true;
            int a = getVal(arr.get(i));
            for (int j=0; j<arr.size(); j++) {
                if (i == j) {continue;}
                int b = getVal(arr.get(j));
                if (a == b) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println(arr.get(i));
            }
        }

        if (count==0) {
            System.out.println("None");
        }
    }

    private int getVal(String num) {
        String[] split = num.split("#");
        int n = Integer.valueOf(split[1]);
        int l = Integer.valueOf(split[0]);

        int w = 1;

        int total = 0;
        for (int i=split[1].length()-1; i>=0; i--) {
            char c = split[1].charAt(i);
            int d = 0;
            if ('0'<=c && c<='9') {
                d = c - '0';
            }
            if ('A'<=c && c<='F') {
                d = 10 + (c - 'A');
            }
            total += (d * (w));
            w = w * l;
        }
        return total;
    }

}
