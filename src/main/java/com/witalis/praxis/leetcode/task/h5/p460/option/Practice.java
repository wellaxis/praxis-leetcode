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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class LFUCache implements ILFUCache {
        private final int capacity;
        private int minFrequency;
        private final Map<Integer, Node> data;
        private final Map<Integer, LinkedHashSet<Node>> cache;

        class Node {
            int key;
            int value;
            int count;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.count = 0;
            }
        }

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFrequency = 0;
            this.data = new HashMap<>();
            this.cache = new HashMap<>();
        }

        @Override
        public int get(int key) {
            final Node node = data.get(key);

            if (node == null || capacity == 0) return -1;

            levelUp(node);
            return node.value;
        }

        @Override
        public void put(int key, int value) {
            if (capacity == 0) return;

            Node node = data.get(key);
            if (node != null) {
                node.value = value;
            } else {
                if (data.size() == capacity) removeLeast();

                node = new Node(key, value);
                data.put(key, node);
            }

            levelUp(node);
        }

        private void levelUp(Node node) {
            if (node == null) return;

            // previous
            LinkedHashSet<Node> nodes = cache.get(node.count);
            if (nodes != null) nodes.remove(node);

            node.count++;

            // current
            nodes = cache.computeIfAbsent(node.count, k -> new LinkedHashSet<>());
            nodes.add(node);

            if (minFrequency == 0 || minFrequency > node.count) {
                minFrequency = node.count;
            }
        }

        private void removeLeast() {
            final LinkedHashSet<Node> nodes = cache.get(minFrequency);
            if (nodes != null && !nodes.isEmpty()) {
                Node head = nodes.stream().findFirst().orElse(null);
                if (head != null) {
                    data.remove(head.key);
                    nodes.remove(head);
                    if (nodes.isEmpty()) {
                        minFrequency = cache.keySet().stream()
                            .filter(key -> !cache.get(key).isEmpty())
                            .min(Integer::compareTo).orElse(0);
                    }
                }
            }
        }
    }

    public List<Integer> process() {
        return LFUCacheHandler.process(operations, new LFUCache(operations.get(0).getValue()[0]));
    }
}
