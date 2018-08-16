package com.tjlcast.Interview_Code._01_stack_and_queue;

import java.util.Stack;
import static java.lang.Math.min;

/**
 *
 * @author tangjialiang
 * @date 2018/7/28
 *
 * 设计一个有getMin功能的栈
 */
public class Solution1 {
    static class MinStack {
        Stack<Integer> datas = new Stack<Integer>();
        Stack<Integer> mins = new Stack<Integer>();

        public void add(int ele) {
            datas.add(ele);
            if (mins.isEmpty()) {
                mins.add(ele);
            } else {
                int curMin = min(mins.peek(), ele);
                mins.add(curMin);
            }
        }

        public int del() {
            mins.pop();
            Integer pop = datas.pop();
            return pop;
        }

        public int getMin() {
            return mins.peek();
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinStack minStack = new MinStack();

        for(Integer ele : arr) {
            minStack.add(ele);
            System.out.println(minStack.getMin());
        }
    }
}
