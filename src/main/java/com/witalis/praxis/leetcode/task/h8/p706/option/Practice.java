package com.witalis.praxis.leetcode.task.h8.p706.option;

import com.witalis.praxis.leetcode.task.h8.p706.content.HashMap;
import com.witalis.praxis.leetcode.task.h8.p706.content.HashMapHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 706
 * Name: Design HashMap
 * URL: <a href="https://leetcode.com/problems/design-hashmap/">Design HashMap</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Integer>>> operations;

    public class MyHashMap implements HashMap<Integer, Integer> {
        public static final int SIZE = 1_000_001;
        private final int[] elements;

        public MyHashMap() {
            this.elements = new int[SIZE];
            Arrays.fill(elements, -1);
        }

        @Override
        public void put(Integer key, Integer value) {
            elements[key] = value;
        }

        @Override
        public Integer get(Integer key) {
            return elements[key];
        }

        @Override
        public void remove(Integer key) {
            elements[key] = -1;
        }

        @Override
        public int size() {
            return Arrays.stream(elements).filter(e -> e > 0).sum();
        }
    }

    public List<String> process() {
        return HashMapHandler.process(operations, new MyHashMap());
    }
}
