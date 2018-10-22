package com.tjlcast.Interview_Code.wangyi_youdao;

/**
 * @author by tangjialiang
 *         时间 2018/9/28.
 *         说明 ...
 */

class A {
    int num = 2;
}

class B extends A {
    int num = 3;
}

public class Pro {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.num);
        System.out.println(((B)(a)).num);
    }

}
