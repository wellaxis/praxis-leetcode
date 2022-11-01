package com.witalis.praxis.leetcode.task.h8.p705.option;

import com.witalis.praxis.leetcode.task.h8.p705.content.HashSetHandler;
import com.witalis.praxis.leetcode.task.h8.p705.content.HashSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 705
 * Name: Design HashSet
 * URL: <a href="https://leetcode.com/problems/design-hashset/">Design HashSet</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyHashSet implements HashSet<Integer> {
        public static final int MAX_SIZE = 1_000_001;
        private final boolean[] elements;
        private int size;

        public MyHashSet() {
            this.elements = new boolean[MAX_SIZE];
            this.size = 0;
        }

        @Override
        public void add(Integer key) {
            if (!elements[key]) size++;
            elements[key] = true;
        }

        @Override
        public void remove(Integer key) {
            if (elements[key]) size--;
            elements[key] = false;
        }

        @Override
        public boolean contains(Integer key) {
            return elements[key];
        }

        @Override
        public int size() {
            return size;
        }
    }

    public List<String> process() {
        return HashSetHandler.process(operations, new MyHashSet());
    }
}
