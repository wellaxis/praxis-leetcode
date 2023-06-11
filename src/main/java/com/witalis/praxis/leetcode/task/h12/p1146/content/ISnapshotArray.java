package com.witalis.praxis.leetcode.task.h12.p1146.content;

/**
 * Desc: Snapshot array interface
 * User: Wellaxis
 * Date: 11.06.2023
 */
public interface ISnapshotArray {
    void set(int index, int val);
    int snap();
    int get(int index, int snapId);
}
