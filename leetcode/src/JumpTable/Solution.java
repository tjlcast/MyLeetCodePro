package JumpTable;

import java.util.Random;

/**
 * @author by tangjialiang
 *         时间 2020/4/3.
 *         说明 ...
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * Get the level according to random jumping.
     * @return the level.
     */
    private int getLevel(){
        int level = 1;
        while (true) {
            int r = new Random().nextInt();
            if (r % 2 == 0) {
                level++;
            } else {
                break;
            }
        }

        System.out.println("本次生成的level："+level);
        return level;
    }


}
