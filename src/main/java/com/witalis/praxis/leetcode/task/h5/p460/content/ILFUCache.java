package com.witalis.praxis.leetcode.task.h5.p460.content;

/**
 * Desc: LFU Cache interface.
 * User: Wellaxis
 * Date: 29/1/2023
 */
public interface ILFUCache {
    int get(int key);
    void put(int key, int value);
}
