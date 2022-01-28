package com.witalis.praxis.leetcode.task.h12.p1114.option;

import com.witalis.praxis.leetcode.task.h12.p1114.content.IFoo;
import com.witalis.praxis.leetcode.task.h12.p1114.content.OrderThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1114
 * Name: Print in Order
 * URL: https://leetcode.com/problems/print-in-order/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Void process() {
        return new Foo(numbers).print();
    }

    class Foo implements IFoo {
        private int[] nums;
        private volatile int counter = 0;

        public Foo() {
            super();
        }

        public Foo(int[] nums) {
            this();
            this.nums = nums;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            while (counter != 0) Thread.onSpinWait();

            printFirst.run();

            trace();
            counter = 1;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (counter != 1) Thread.onSpinWait();

            printSecond.run();

            trace();
            counter = 2;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (counter != 2) Thread.onSpinWait();

            printThird.run();

            trace();
            counter = 3;
        }

        private Void print() {
            Thread a = new OrderThread("A", this, nums[0] - 1);
            Thread b = new OrderThread("B", this, nums[1] - 1);
            Thread c = new OrderThread("C", this, nums[2] - 1);

            a.start();
            b.start();
            c.start();

            return null;
        }

        private void trace() {
            log.trace("Thread: '{}'", Thread.currentThread().getName());
        }
    }
}
