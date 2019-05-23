package com.tjlcast.clazz_byte_operation.proxy_dynamic.jdk;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明 ...
 */

/**
 * 电能车类，实现Rechargable，Vehicle接口
 */
public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }
}