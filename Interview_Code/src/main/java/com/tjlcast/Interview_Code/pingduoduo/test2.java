package com.tjlcast.Interview_Code.pingduoduo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zhangzy * @Date:2017/11/18
 */
public class test2 {
    public static int solution() {
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();
        return helper(0, 0, map);
    }

    public static int helper(int x, int y, Map<Integer, Map<Integer, Boolean>> map) {
        int up = 0, down = 0, left = 0, right = 0;
        if (map.containsKey(x)) {
            if (map.get(x).containsKey(y)) {
                return 0;
            } else {
                map.get(x).put(y, true);
            }
        } else {
            Map<Integer, Boolean> temp = new HashMap<>();
            temp.put(y, true);
            map.put(x, temp);
        }
        if (move(0)) {
            up = helper(x - 1, y, map);
        }
        if (move(1)) {
            down = helper(x + 1, y, map);
        }
        if (move(2)) {
            left = helper(x, y - 1, map);
        }
        if (move(3)) {
            right = helper(x, y + 1, map);
        }
        return up + down + left + right + 1;
    }
//这里只是声明一下 public static boolean move(int direction){ return true;  }
}
