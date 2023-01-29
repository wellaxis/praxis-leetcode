package com.witalis.praxis.leetcode.task.h5.p460.option;

import com.witalis.praxis.leetcode.task.h5.p460.content.ILFUCache;
import com.witalis.praxis.leetcode.task.h5.p460.content.LFUCacheHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 460
 * Name: LFU Cache
 * URL: <a href="https://leetcode.com/problems/lfu-cache/">LFU Cache</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class LFUCache implements ILFUCache {
        private final int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public int get(int key) {
            return -1;
        }

        @Override
        public void put(int key, int value) {
        }
    }

    public List<Integer> process() {
        return LFUCacheHandler.process(operations, new LFUCache(operations.get(0).getValue()[0]));
    }
}
