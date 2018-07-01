package com.tjlcast.MyLintCode.test;

/**
 * Created by tangjialiang on 2018/7/1.
 *
 *
 * 内部类和lambda还真的不一样。

 lambda是在当前类里添加里一个bootstrap method，bootstrap method会返回一个callsite，而callsite可以理解为指向方法的地址，方法的信息要{依赖于类的完整初始化}。
 所以在子线程内生成callsite时会等待类的初始化，而类的初始化又依赖于stream执行完成，所以死锁。

 但内部类不一样。
 内部类是一个独立的类，其类初始化只与其继承、实现、字段类型、方法返回及参数类型相关。
 在使用内部类时，传递给filter方法的是在主线程内创建好的实例，而内部类的类初始化并不依赖于外部类，所以使用内部类时不会出现死锁的问题。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(Test.name);
    }

    static class Test{
        public static String name;

        static {
            name = getNamePro();
        }

        private static String getNameNative() {
            List<String> datas = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                datas.add("a" + i);
            }

            //  匿名内部类
            datas = datas.parallelStream()
                    .filter(s -> s.equalsIgnoreCase("a9")).collect(Collectors.toList());
            return datas.get(0);
        }

        private static String getNamePro(){
            List<String> datas = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                datas.add("a" + i);
            }

            //  匿名内部类
            datas = datas.parallelStream()
                    .filter(new Predicate<String>() {
                        @Override
                        public boolean test(String s) {
                            return s.equalsIgnoreCase("a9");
                        }
                    }).collect(Collectors.toList());
            return datas.get(0);
        }
    }
}