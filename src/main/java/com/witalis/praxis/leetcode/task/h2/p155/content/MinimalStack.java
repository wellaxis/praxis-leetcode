package com.witalis.praxis.leetcode.task.h2.p155.content;

/**
 * Desc: Minimal stack interface
 * User: Wellaxis
 * Date: 11.01.2022
 */
public interface MinimalStack {
    void push(int x);
    void pop();
    int top();
    int getMin();
}
