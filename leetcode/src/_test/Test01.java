package _test;

/**
 * @author by tangjialiang
 *         时间 2019/7/3.
 *         说明 ...
 */

class A {
    public String hello() {
        return "this is A";
    }
}

class B extends A{
    @Override
    public String hello() {
        return "this is B";
    }
}

public class Test01 {

    public static void main(String[] args) {
        A b = new B();
        String str = b.hello();

        System.out.println(str);
    }
}
