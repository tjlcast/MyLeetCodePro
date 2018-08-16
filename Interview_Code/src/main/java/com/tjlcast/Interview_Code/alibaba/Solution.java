package com.tjlcast.Interview_Code.alibaba;

/**
 *
 * @author tangjialiang
 * @date 2018/7/29
 */
public class Solution {

    static int maxN;
    static int numT;

    public static void main(String[] args) {
        maxN = 100;
        numT = 5;
        MyLock lock = new MyLock(1);

        for(int i=0; i<numT; i++) {
            new MyThread(i+1, numT, lock).start();
        }
    }

    static class MyLock {
        int next;
        public MyLock(int next) {
            this.next = next;
        }
    }

    static class MyThread extends Thread {
        private int step;
        private int no;
        private MyLock lock;

        public MyThread(int no, int step, MyLock lock) {
            this.no = no;
            this.step = step;
            this.lock = lock;
        }

        @Override
        public void run() {
            int i = no;
            while(i <= maxN) {
                synchronized (lock) {
                    if (lock.next == no) {
                        System.out.println("Printer-"+no+": "+i);
                        i += step;
                        if (lock.next+1 <= step) {
                            lock.next += 1;
                        } else {
                            lock.next = 1;
                        }
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
