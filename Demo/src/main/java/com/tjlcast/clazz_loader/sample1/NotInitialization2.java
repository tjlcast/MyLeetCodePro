package com.tjlcast.clazz_loader.sample1;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类。（编译器的优化）
 */
public class NotInitialization2 {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
