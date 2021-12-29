package com.witalis.praxis.leetcode.task.p1114.option;

import com.witalis.praxis.leetcode.task.p1114.content.IFoo;
import com.witalis.praxis.leetcode.task.p1114.content.OrderThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1114
 * Name: Print in Order
 * URL: https://leetcode.com/problems/print-in-order/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Void process() {
        return new Foo(numbers).print();
    }

    class Foo implements IFoo {
        private int[] nums;
        private int counter = 0;

        public Foo() {
            super();
        }

        public Foo(int[] nums) {
            this();
            this.nums = nums;
        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (this) {
                while (counter != 0) {
                    wait();
                }

                printFirst.run();
                trace();

                counter++;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (this) {
                while (counter != 1) {
                    wait();
                }

                printSecond.run();
                trace();

                counter++;
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (this) {
                while (counter != 2) {
                    wait();
                }

                printThird.run();
                trace();

                counter++;
                notifyAll();
            }
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
