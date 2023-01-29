package com.witalis.praxis.leetcode.task.h5.p460.option;

import com.witalis.praxis.leetcode.task.h5.p460.content.ILFUCache;
import com.witalis.praxis.leetcode.task.h5.p460.content.LFUCacheHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 460
 * Name: LFU Cache
 * URL: <a href="https://leetcode.com/problems/lfu-cache/">LFU Cache</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class Pair<K extends Number, V extends Number> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    class LFUCache implements ILFUCache {
        // key: original key, value: frequency and original value
        private Map<Integer, Pair<Integer, Integer>> cache;
        // key: frequency, value: all keys that have the same frequency
        private Map<Integer, LinkedHashSet<Integer>> frequencies;
        private int minf;
        private int capacity;

        private void insert(int key, int frequency, int value) {
            cache.put(key, new Pair<>(frequency, value));
            frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
            frequencies.get(frequency).add(key);
        }

        public LFUCache(int capacity) {
            this.cache = new HashMap<>();
            this.frequencies = new HashMap<>();
            this.minf = 0;
            this.capacity = capacity;
        }

        @Override
        public int get(int key) {
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue == null) {
                return -1;
            }
            final int frequency = frequencyAndValue.getKey();
            final Set<Integer> keys = frequencies.get(frequency);
            keys.remove(key);
            if (minf == frequency && keys.isEmpty()) {
                ++minf;
            }
            final int value = frequencyAndValue.getValue();
            insert(key, frequency + 1, value);
            return value;
        }

        @Override
        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue != null) {
                cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
                get(key);
                return;
            }
            if (capacity == cache.size()) {
                final Set<Integer> keys = frequencies.get(minf);
                final int keyToDelete = keys.iterator().next();
                cache.remove(keyToDelete);
                keys.remove(keyToDelete);
            }
            minf = 1;
            insert(key, 1, value);
        }
    }

    public List<Integer> process() {
        return LFUCacheHandler.process(operations, new LFUCache(operations.get(0).getValue()[0]));
    }
}
