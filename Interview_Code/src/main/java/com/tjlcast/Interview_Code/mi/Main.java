package com.tjlcast.Interview_Code.mi;

import java.util.Scanner;

/**
 * @author by tangjialiang
 *         时间 2018/9/20.
 *         说明 ...
 */

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMaxCapacity(int[] array, int m) {
        getC(array);
        array[0]=array[0] + m;
        int v1 = getC(array);
        array[0]=array[0] - m;
        array[array.length-1]=array[array.length-1] + m;
        int v2 = getC(array);
        return Math.max(v1, v2);
    }

    static int getC(int[] array) {
        int mV=0;
        int mI=0;
        for (int i=0; i<array.length; i++) {
            if (array[i] > mV) {
                mV = array[i];
                mI = i;
            }
        }

        int total = 0;

        int lastH = array[0];
        for(int i=0; i<mI; i++) {
            if (array[i] < lastH) {total += (lastH - array[i]);}
            if (array[i] > lastH) {lastH = array[i];}
        }
        lastH = array[array.length-1];
        for(int i=array.length-1; i>mI; i--) {
            if (array[i] < lastH) {total += (lastH - array[i]);}
            if (array[i] > lastH) {lastH = array[i];}
        }
        return total;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for(int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = findMaxCapacity(_array, _m);
        System.out.println(String.valueOf(res));

    }
}