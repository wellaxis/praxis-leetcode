package com.witalis.praxis.leetcode.task.h2.p146.option;

import com.witalis.praxis.leetcode.task.h2.p146.content.ILRUCache;
import com.witalis.praxis.leetcode.task.h2.p146.content.LRUCacheHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 146
 * Name: LRU Cache
 * URL: <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class LRUCache extends LinkedHashMap<Integer, Integer> implements ILRUCache {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity + 1, 1.1F, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }

        @Override
        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        public void put(int key, int value) {
            super.put(key, value);
        }
    }

    public List<Integer> process() {
        return LRUCacheHandler.process(operations, new LRUCache(operations.get(0).getValue()));
    }
}
