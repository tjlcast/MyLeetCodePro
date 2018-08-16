package com.tjlcast.Interview_Code.alibaba;

import static java.lang.System.out;

/**
 * Created by tangjialiang on 2018/7/29.
 */
public class MainPro {
    static int limit  = 0;
    static int count = 0;

    static  class Lock{
        int count ;
        public Lock(int i){
            this.count = i;
        }
    }

    /*
     * 实现print方法，输入一个数字，通过多线程的方式按线程顺序依次打印1~100
     * 比如输入5，输出
     * Printer-1: 1
     * Printer-2: 2
     * Printer-3: 3
     * Printer-4: 4
     * Printer-5: 5
     * Printer-1: 6
     * Printer-2: 7
     * ...
     * Printer-5: 100
     *
     */
    public static void main(String[] args){
        limit = 100;    // 打印的数据的上限，从1开始
        count = 5;      // 启动的线程

        Lock l = new Lock(1);
        for(int i=1; i<=count; i++){
            new Mythread(i,l).start();
        }
    }


    static class Mythread extends Thread{
        final int index;
        final Lock lock;

        public Mythread(int index, Lock lock){
            this.index = index;
            this.lock = lock;
        }

        @Override
        public void run(){
            int i = index;
            while(i<=limit){
                synchronized (lock){
                    if(lock.count==index){
                        out.println("Pinter-"+index+": "+i);
                        i += count;
                        if(lock.count<count){
                            lock.count++;
                        }else{
                            lock.count = 1;
                        }
                        lock.notifyAll();
                    }else{
                        try{
                            lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }


    static class Helper {
        public static String outNeedAddOne(int i) {
            return String.valueOf(i+1);
        }
    }
}