package com.witalis.praxis.leetcode.task.p1114.content;

import lombok.extern.slf4j.Slf4j;

/**
 * Desc: Order thread
 * User: Wellaxis
 * Date: 29.12.2021
 */
@Slf4j
public class OrderThread extends Thread {
    private final IFoo foo;
    private final int number;

    public OrderThread(String name, IFoo foo, int number) {
        super(name);
        this.foo = foo;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            switch (number) {
                case 0 -> foo.first(() -> System.out.print("first"));
                case 1 -> foo.second(() -> System.out.print("second"));
                case 2 -> foo.third(() -> System.out.print("third"));
                default -> throw new IllegalArgumentException("Unexpected thread index.");
            }
        } catch (Exception e) {
            log.error("Printing errors", e);
        }
    }
}
