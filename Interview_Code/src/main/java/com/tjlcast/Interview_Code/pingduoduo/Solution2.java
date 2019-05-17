package com.tjlcast.Interview_Code.pingduoduo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by tangjialiang
 *         时间 2019/1/27.
 *         说明 ...
 */
public class Solution2 {

    static int x = 0, y = 0;

    public static boolean move(int dir) {
        int[][] array = {
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int x_m = array.length;
        int y_m = array[0].length;
        switch (dir) {
            case 0:
                if (y + 1 >= y_m || array[x][y + 1] != 0) {
                    return false;
                }
                y++;
                break;
            case 1:
                if (x + 1 >= x_m || array[x + 1][y] != 0) {
                    return false;
                }
                x++;
                break;
            case 2:
                if (y - 1 < 0 || array[x][y - 1] != 0) {
                    return false;
                }
                y--;
                break;
            case 3:
                if (x - 1 < 0 || array[x - 1][y] != 0) {
                    return false;
                }
                x--;
                break;
            default:
                break;
        }
        return true;
    }

    public static int problem3(int x, int y, Set<String> set) {
        set.add(x + "," + y);

        if (!set.contains(x + "," + (y + 1)) && move(0)) {
            problem3(x, y + 1, set);
            move(2);
        }
        if (!set.contains((x + 1) + "," + y) && move(1)) {
            problem3(x + 1, y, set);
            move(3);
        }
        if (!set.contains(x + "," + (y - 1)) && move(2)) {
            problem3(x, y - 1, set);
            move(0);
        }
        if (!set.contains((x - 1) + "," + y) && move(3)) {
            problem3(x - 1, y, set);
            move(1);
        }
        return set.size();
    }


    public static void main(String[] String) {
        Set<String> set = new HashSet<String>();
        System.out.println(problem3(0, 0, set));
    }


}
