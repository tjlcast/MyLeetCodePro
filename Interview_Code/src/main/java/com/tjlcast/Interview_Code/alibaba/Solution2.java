package com.tjlcast.Interview_Code.alibaba;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author tangjialiang
 * @date 2018/7/31
 */
public class Solution2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, null);
        int nThread = 5;
        int maxNum = 100;

        MyThreadPool myThreadPool = new MyThreadPool(nThread, maxNum);
        myThreadPool.init();
        myThreadPool.start();
    }

    static class MyThreadPool {
        private int maxNum;
        private int size;
        private MyLock lock;
        private List<NodeThread> threads;

        public MyThreadPool(int size, int maxNum) {
            this.maxNum = maxNum;
            this.size = size;
            this.lock = new MyLock(1);
            threads = new LinkedList<NodeThread>();
        }

        public void init() {
            NodeThread lastT = null;
            for(int i=0; i<size; i++) {
                NodeThread nodeThread = new NodeThread(i+1, lock, this);
                threads.add(nodeThread);

                if (lastT != null) {
                    lastT.next = nodeThread;
                }
                lastT = nodeThread;
            }
            lastT.next = threads.get(0);
        }

        public void start() {
            for(int i=0; i<size; i++) {
                threads.get(i).start();
            }
        }
    }

    static class NodeThread extends Thread{
        private NodeThread next;
        private int index ;
        private MyLock lock;
        private MyThreadPool threadPool;

        public NodeThread(int index, MyLock lock, MyThreadPool threadPool) {
            this.index = index;
            this.lock = lock;
            this.threadPool = threadPool;
        }

        @Override
        public void run() {
            int i = index;
            while (i <= threadPool.maxNum) {
                synchronized (MyThreadPool.class) {
                    if (index == lock.next) {
                        System.out.println("Printer-"+index+" : " + i);
                        i += threadPool.size;
                        lock.next += 1;
                        if (lock.next > threadPool.size) {
                            lock.next = 1;
                        }
                        next.notify();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class MyLock {
        int next;
        public MyLock(int next) {this.next = next;}
    }
}
