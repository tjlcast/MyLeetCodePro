package com.tjlcast.demo01.entity;

/**
 * Created by tangjialiang on 2018/5/26.
 */
public class Result<T> {

    public int code ;
    public String msg ;
    public T data ;
    public long count ;
    public long page ;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                '}';
    }
}
