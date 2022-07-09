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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class LRUCache extends LinkedHashMap<Integer, Integer> implements ILRUCache {

        private class Node{
            public int val;
            public int key;
            public Node prev = null;
            public Node next = null;
        }

        private Node[] cache;
        private Node tail;
        private Node head;
        private int size;
        private int limit;

        public LRUCache(int capacity) {
            limit = capacity;
            size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            cache = new Node[10001];
        }

        public int get(int key) {
            if (cache[key] == null) return -1;

            fresh(cache[key]);

            return cache[key].val;
        }

        public void put(int key, int value) {
            if (cache[key] == null) {
                if (size == limit) {
                    cache[tail.prev.key] = null;
                    tail.prev.prev.next = tail;
                    tail.prev = tail.prev.prev;
                    size--;
                }

                size++;
                cache[key] = new Node();
            }

            cache[key].key = key;
            cache[key].val = value;
            fresh(cache[key]);
        }

        private void fresh(Node recent) {
            if (recent.prev != null && recent.next != null) {
                recent.prev.next = recent.next;
                recent.next.prev = recent.prev;
            }
            recent.prev = head;
            recent.next = head.next;
            head.next.prev = recent;
            head.next = recent;
        }
    }

    public List<Integer> process() {
        return LRUCacheHandler.process(operations, new LRUCache(operations.get(0).getValue()));
    }
}
