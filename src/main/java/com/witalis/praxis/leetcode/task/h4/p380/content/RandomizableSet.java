package com.witalis.praxis.leetcode.task.h4.p380.content;

/**
 * Desc: Randomizable set interface.
 * User: Wellaxis
 * Date: 11/29/2022
 */
public interface RandomizableSet<T> {
    boolean insert(T value);
    boolean remove(T value);
    T getRandom();
}
