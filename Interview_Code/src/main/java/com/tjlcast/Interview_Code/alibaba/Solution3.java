package com.tjlcast.Interview_Code.alibaba;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2018/8/2.
 */
public class Solution3 implements Runnable{

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        Solution3 solution3 = new Solution3();
        scheduledExecutorService.scheduleAtFixedRate(solution3, 4, 2, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + ": "+System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
