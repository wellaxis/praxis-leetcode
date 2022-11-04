package com.witalis.praxis.leetcode.task.h8.p706.content;

/**
 * Desc: Hash map interface.
 * User: Wellaxis
 * Date: 4/11/2022
 */
public interface HashMap<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    int size();
}
