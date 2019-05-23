package com.tjlcast.clazz_byte_operation.jdk_classloader;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明 ...
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}
