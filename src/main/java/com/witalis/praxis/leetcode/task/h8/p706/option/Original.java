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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Integer>>> operations;

    public class MyHashMap<K, V> implements HashMap<K, V> {
        private final List<K> keys;
        private final List<V> values;

        public MyHashMap() {
            this.keys = new ArrayList<>();
            this.values = new ArrayList<>();
        }

        @Override
        public void put(K key, V value) {
            int index = keys.indexOf(key);
            if (index < 0) {
                index = keys.size();
                keys.add(index, key);
                values.add(index, value);
            } else {
                values.set(index, value);
            }
        }

        @Override
        public V get(K key) {
            int index = keys.indexOf(key);

            return (index < 0) ? null : values.get(index);
        }

        @Override
        public void remove(K key) {
            int index = keys.indexOf(key);
            if (index >= 0) {
                keys.remove(index);
                values.remove(index);
            }
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    public List<String> process() {
        return HashMapHandler.process(operations, new MyHashMap<>());
    }
}
