package com.witalis.praxis.leetcode.task.h8.p705.option;

import com.witalis.praxis.leetcode.task.h8.p705.content.HashSetHandler;
import com.witalis.praxis.leetcode.task.h8.p705.content.HashSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 705
 * Name: Design HashSet
 * URL: <a href="https://leetcode.com/problems/design-hashset/">Design HashSet</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyHashSet implements HashSet<Integer> {
        private final List<Integer> list;

        public MyHashSet() {
            this.list = new ArrayList<>();
        }

        @Override
        public void add(Integer key) {
            int i = Collections.binarySearch(list, key);
            if (i < 0) {
                list.add(-i - 1, key);
            }
        }

        @Override
        public void remove(Integer key) {
            int i = Collections.binarySearch(list, key);
            if (i >= 0) list.remove(i);
        }

        public boolean contains(Integer key) {
            int k = Collections.binarySearch(list, key);
            return k >= 0;
        }

        @Override
        public int size() {
            return list.size();
        }
    }

    public List<String> process() {
        return HashSetHandler.process(operations, new MyHashSet());
    }
}
