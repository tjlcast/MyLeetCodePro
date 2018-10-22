package com.tjlcast.Interview_Code.Bzhan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/10/18.
 *         说明 ...
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        String[] split1 = split[0].split(" ");

        int N = Integer.parseInt(split[1]);
        int[] nums = new int[split1.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(split1[i]);
        }

        boolean ans = false;
//        for (int i=0; i<nums.length; i++) {
//            for (int j=i+1; j<nums.length; j++) {
//                for (int k=j+1; k<nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == N) {
//                        ans = true;
//                    }
//                }
//            }
//        }
        List<List<Integer>> lists = new Solution().threeSum(nums, N);
        if (lists!=null && lists.size()!=0) {
            ans = true;
        }

        if (ans) {
            System.out.println("True") ;
        } else {
            System.out.println("False");
        }

    }

    private List<List<Integer>> ans = new LinkedList<>() ;

    public List<List<Integer>> threeSum(int[] nums, int aim) {
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            int reminder = aim - nums[i] ;
            int l = i + 1 ;
            int r = nums.length - 1 ;

            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }

            while(l < r) {
                if (reminder == nums[l] + nums[r]) {
                    List<Integer> line = new LinkedList<>(Arrays.asList(nums[i], nums[l], nums[r])) ;
                    ans.add(line) ;
                    l += 1 ;
                    r -= 1 ;
                    while(l < r && nums[l]==nums[l-1])l += 1 ;
                    while(l < r && nums[r]==nums[r+1])r -= 1 ;
                } else if (reminder < nums[l] + nums[r]) {
                    r -= 1 ;
                } else {
                    l += 1 ;
                }
            }
        }

        return ans ;
    }
}
