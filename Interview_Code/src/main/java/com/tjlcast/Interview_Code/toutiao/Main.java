package com.tjlcast.Interview_Code.toutiao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by tangjialiang
 *         时间 2018/8/12.
 *         说明 ...
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = work(nums, target);
        if (ans == null) return ;
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static int[] work(int[] datas, int target) {
        Map<Integer, Integer> recorders = new HashMap<>(); // data -> pos

        for (int i=0; i<datas.length; i++) {
            int data = datas[i];
            int rest = target - data;

            if (recorders.containsKey(rest)) {
                int[] ans = new int[2];
                ans[0] = recorders.get(rest);
                ans[1] = i;
                return ans;
            }
            recorders.put(data, i);
        }

        //throw new Excepjavascript:void(0);tion("not validate input");
        System.out.println("not validate input");
        return null;
    }
}