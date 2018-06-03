package com.tjlcast.demo03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 用于标志服务接口类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HttpApi {
    String value() default "" ; // 通过key获得配置文件中的值
    Class[] interceptor() default {} ;
}
