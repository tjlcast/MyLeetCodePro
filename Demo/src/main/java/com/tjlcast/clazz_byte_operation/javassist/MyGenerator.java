package com.tjlcast.clazz_byte_operation.javassist;

import javassist.*;

import java.io.IOException;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明 ...
 */
public class MyGenerator {

    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();

        // 创建 Programmer 类
        CtClass ctClass = pool.makeClass("com.tjlcast.clazz_byte_operation.javassist.Programmer");

        // 定义 code 方法
        CtMethod methode = CtNewMethod.make("public void code(){}", ctClass);

        // 插入 code 方法代码
        methode.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");

        // 把编写好的 code 方法加入 Programmer 类中
        ctClass.addMethod(methode);

        ctClass.writeFile("");  // modilfy
    }
}
