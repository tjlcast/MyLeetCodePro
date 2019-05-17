package com.tjlcast.Interview_Code.pingduoduo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author by tangjialiang
 *         时间 2019/1/27.
 *         说明 ...
 */
public class Solution {

    public int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public boolean move(int direction) {
        // todo
        return false;
    }


    public int area() {
        HashMap<Integer, HashSet<Integer>> info = new HashMap<>();

        int time = 0;
        int row = 0 ;
        int col = 0 ;
        int dIdx = 0 ;

        info.getOrDefault(row, new HashSet<Integer>()).add(col);

        while (true) {
            while (move(dIdx)) {
                time = 0;
                row += directions[dIdx][0];
                col += directions[dIdx][1];
                info.getOrDefault(row, new HashSet<Integer>()).add(col);
            }
            if (time >= 4) {
                break;
            }
            dIdx = (dIdx + 1) % 4;
            time++;
        }

        return count(info);
    }

    private int count(HashMap<Integer, HashSet<Integer>> infos) {
        int total = 0;
        for (Map.Entry<Integer, HashSet<Integer>> rows : infos.entrySet()) {
            for (Integer cols : rows.getValue()) {
                total++;
            }
        }
        return total;
    }
}
