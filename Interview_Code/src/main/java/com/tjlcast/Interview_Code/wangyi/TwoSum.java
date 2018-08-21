package com.tjlcast.Interview_Code.wangyi;

import java.util.HashMap;

/**
 * @author by tangjialiang
 *         时间 2018/8/21.
 *         说明 ...
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> restMapper = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int idx = i;

            int rest = target - num;
            if (restMapper.containsKey(rest)) {
                int[] ans = {restMapper.get(rest), idx};
                return ans;
            } else {
                restMapper.put(num, idx);
            }
        }
        return null;
    }
}
