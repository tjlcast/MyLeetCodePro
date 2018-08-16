package com.tjlcast.Interview_Code._01_stack_and_queue;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author tangjialiang
 * @date 2018/7/28
 *
 * 由两个栈组成的队列
 */
public class Solution2 {

    static class QueueByStack {
        Stack<Integer> stackA = new Stack<Integer>();
        Stack<Integer> stackB = new Stack<Integer>();

        public void add(int val) {
            stackA.add(val);
            return ;
        }

        public int poll() {
            if (stackB.isEmpty()) {
                move();
            }
            if (stackB.isEmpty()) {
                return -1;
            }
            return stackB.pop();
        }

        public int peek() {
            if (stackB.isEmpty()) {
                move();
            }
            if (stackB.isEmpty()) {
                return -1;
            }
            return stackB.peek();
        }

        private void move() {
            while(!stackA.isEmpty()) {
                stackB.add(stackA.pop());
            }
        }

        public boolean isEmpty() {
            return (stackA.isEmpty()) && (stackB.isEmpty());
        }
    }

    public static void main(String[] args) {
        // test
        QueueByStack queueByStack = new QueueByStack();
        int[] datas = {1, 2, 3, 4, 5, 6, 7};


        for(Integer i: datas) {
            System.out.println("add: - " + i);
            queueByStack.add(i);

            if (new Random().nextInt()%2 == 0) {
                System.out.println(queueByStack.poll());
            }
        }

        while (!queueByStack.isEmpty()) {
            System.out.println(queueByStack.poll());
        }
    }
}
