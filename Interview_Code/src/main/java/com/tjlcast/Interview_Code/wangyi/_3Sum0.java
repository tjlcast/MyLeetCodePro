package com.tjlcast.Interview_Code.wangyi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by tangjialiang
 *         时间 2018/8/21.
 *         说明 ...
 */
public class _3Sum0 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int rest = 0 - nums[i];
            int l = i+1;
            int r = nums.length-1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while(l < r) {
                if (nums[l]+nums[r] == rest) {
                    // == rest
                    ans.add(Arrays.asList(i, l, r));
                    l += 1;
                    r -= 1;
                    while (l < r && nums[l]==nums[l-1]) {
                        l += 1;
                    }
                    while (l < r && nums[r]==nums[r+1]) {
                        r -= 1;
                    }
                } else if (nums[l]+nums[r] > rest){
                    // > rest
                    r-- ;
                } else {
                    // < rest
                    r++;
                }
            }
        }

        return ans;
    }
}
