package com.witalis.praxis.leetcode.task.h27.p2642.content;

/**
 * Desc: Shortest graph path calculator interface.
 * User: Wellaxis
 * Date: 11/11/2023
 */
public interface IShortestGraphPathCalculator {
    void addEdge(int[] edge);
    int shortestPath(int node1, int node2);
}
