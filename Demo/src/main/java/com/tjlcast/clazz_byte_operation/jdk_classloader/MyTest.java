package com.tjlcast.clazz_byte_operation.jdk_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明  静态代码
 *              通过类加载系统加载class文件并生成class对象，之后通过jdk反射实例化对象。
 */
public class MyTest {

    public static void main(String[] args) throws IOException {
        // 读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");
        String pathClazz = "/Demo/target/classes/com/tjlcast/clazz_byte_operation/jdk/Programmer.class";
        FileInputStream fileInputStream = new FileInputStream(file.getCanonicalPath()
                + pathClazz);
        byte[] bytes = new byte[1024];

        int count = fileInputStream.read(bytes);

        // 使用自定义的类加载器将 byte 字节码数组转化为对应的class对象
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.defineMyClass(bytes, 0, count);

        // 测试加载是否成功，打印clazz 对象的名称
        System.out.println(clazz.getCanonicalName());

        try {
            // 实例化一个 Programmer 对象
            Object o = clazz.newInstance();
//            Programmer p = (Programmer)o;

            // 调用 Programmer 的 code 方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
