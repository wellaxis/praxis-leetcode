package com.witalis.praxis.leetcode.task.h3.p208.content;

/**
 * Desc: Trie interface.
 * User: Wellaxis
 * Date: 5/13/2022
 */
public interface ITrie {
    void insert(String word);
    boolean search(String word);
    boolean startsWith(String prefix);
}
