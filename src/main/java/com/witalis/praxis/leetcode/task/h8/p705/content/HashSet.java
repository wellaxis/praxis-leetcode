package com.witalis.praxis.leetcode.task.h8.p705.content;

/**
 * Desc: Hash set interface.
 * User: Wellaxis
 * Date: 1/11/2022
 */
public interface HashSet<E> {
    void add(E key);
    void remove(E key);
    boolean contains(E key);
    int size();
}
