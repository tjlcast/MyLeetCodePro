package com.tjlcast.myjucdemo.atomicOps;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by tangjialiang on 2018/5/29.
 */
public class Example02 {
    /**
     *  数组 的原子 相对于AtomicInteger 就是多一个下标
     void set(int i, int newValue)
     void lazySet(int i, int newValue)
     int getAndSet(int i, int newValue)
     boolean compareAndSet(int i, int expect, int update)
     boolean weakCompareAndSet(int i, int expect, int update)
     int getAndIncrement(int i)
     int getAndDecrement(int i)
     int getAndAdd(int i, int delta)
     int incrementAndGet(int i)
     int decrementAndGet(int i)
     int addAndGet(int i, int delta)
     */


    /**
     * AtomicIntegerFieldUpdater<T>/AtomicLongFieldUpdater<T>/AtomicReferenceFieldUpdater<T,V>
     *     是基于反射的原子更新字段的值。
     */
    class DemoData{
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }
    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }
    void doit() {
        DemoData data = new DemoData();
        System.out.println("1 ==> "+getUpdater("value1").getAndSet(data, 10));
        System.out.println("3 ==> "+getUpdater("value2").incrementAndGet(data));
        System.out.println("2 ==> "+getUpdater("value3").decrementAndGet(data));
        System.out.println("true ==> "+getUpdater("value4").compareAndSet(data, 4, 5));
    }
    public static void main(String[] args) {
        Example02 demo = new Example02();
        demo.doit();
    }
}
