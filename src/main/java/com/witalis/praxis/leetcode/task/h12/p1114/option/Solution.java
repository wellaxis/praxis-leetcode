package com.witalis.praxis.leetcode.task.h12.p1114.option;

import com.witalis.praxis.leetcode.task.h12.p1114.content.IFoo;
import com.witalis.praxis.leetcode.task.h12.p1114.content.OrderThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * ID: 1114
 * Name: Print in Order
 * URL: https://leetcode.com/problems/print-in-order/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Void process() {
        return new Foo(numbers).print();
    }

    class Foo implements IFoo {
        private int[] nums;
        private Semaphore semaphore1 = new Semaphore(0);
        private Semaphore semaphore2 = new Semaphore(0);

        public Foo() {
            super();
        }

        public Foo(int[] nums) {
            this();
            this.nums = nums;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphore1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore1.acquire();
            printSecond.run();
            semaphore2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore2.acquire();
            printThird.run();
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
