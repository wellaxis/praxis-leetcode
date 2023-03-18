package com.witalis.praxis.leetcode.task.h15.p1472.content;

/**
 * Desc: Browser history interface.
 * User: Wellaxis
 * Date: 3/18/2023
 */
public interface IBrowserHistory {
    void visit(String url);
    String back(int steps);
    String forward(int steps);
}
