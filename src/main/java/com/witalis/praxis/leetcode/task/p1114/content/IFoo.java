package com.witalis.praxis.leetcode.task.p1114.content;

/**
 * Desc: Foo interface
 * User: Wellaxis
 * Date: 29.12.2021
 */
public interface IFoo {
    void first(Runnable runnable) throws InterruptedException;
    void second(Runnable runnable) throws InterruptedException;
    void third(Runnable runnable) throws InterruptedException;
}
