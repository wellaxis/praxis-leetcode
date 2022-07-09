package com.witalis.praxis.leetcode.task.h2.p146.content;

/**
 * Desc: LRU Cache interface.
 * User: Wellaxis
 * Date: 9/7/2022
 */
public interface ILRUCache {
    int get(int key);
    void put(int key, int value);
}
