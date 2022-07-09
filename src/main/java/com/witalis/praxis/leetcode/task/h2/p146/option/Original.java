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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class LRUCache implements ILRUCache {
        private final int capacity;
        private final Map<Integer, Integer> values;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.values = new LinkedHashMap<>(capacity, 0.75F, true);
        }

        @Override
        public int get(int key) {
            return values.getOrDefault(key, -1);
        }

        @Override
        public void put(int key, int value) {
            values.put(key, value);
            Integer head = values.entrySet().iterator().next().getKey();
            if (values.size() > capacity) values.remove(head);
        }
    }

    public List<Integer> process() {
        return LRUCacheHandler.process(operations, new LRUCache(operations.get(0).getValue()));
    }
}
