package com.witalis.praxis.leetcode.task.h8.p705.option;

import com.witalis.praxis.leetcode.task.h8.p705.content.HashSetHandler;
import com.witalis.praxis.leetcode.task.h8.p705.content.HashSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 705
 * Name: Design HashSet
 * URL: <a href="https://leetcode.com/problems/design-hashset/">Design HashSet</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyHashSet<E> implements HashSet<E> {
        private final Map<E, E> map;

        public MyHashSet() {
            this.map = new HashMap<>();
        }

        @Override
        public void add(E key) {
            map.put(key, key);
        }

        @Override
        public void remove(E key) {
            map.remove(key);
        }

        @Override
        public boolean contains(E key) {
            return map.containsKey(key);
        }

        @Override
        public int size() {
            return map.size();
        }
    }

    public List<String> process() {
        return HashSetHandler.process(operations, new MyHashSet<>());
    }
}
