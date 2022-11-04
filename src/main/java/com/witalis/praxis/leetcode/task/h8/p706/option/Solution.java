package com.witalis.praxis.leetcode.task.h8.p706.option;

import com.witalis.praxis.leetcode.task.h8.p706.content.HashMap;
import com.witalis.praxis.leetcode.task.h8.p706.content.HashMapHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 706
 * Name: Design HashMap
 * URL: <a href="https://leetcode.com/problems/design-hashmap/">Design HashMap</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Integer>>> operations;

    public class MyHashMap implements HashMap<Integer, Integer> {
        public static final int SIZE = 10_000;
        private final ListNode[] nodes;

        static class ListNode {
            protected int key;
            protected int value;
            protected ListNode next;

            ListNode(int key, int value, ListNode next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        public MyHashMap() {
            this.nodes = new ListNode[SIZE];
        }

        @Override
        public void put(Integer key, Integer value) {
            int hash = key % SIZE;
            ListNode node = find(nodes[hash], key);
            if (node != null) {
                node.value = value;
            } else {
                nodes[hash] = new ListNode(key, value, nodes[hash]);
            }
        }

        @Override
        public Integer get(Integer key) {
            int hash = key % SIZE;
            ListNode node = find(nodes[hash], key);

            return (node == null) ? -1 : node.value;
        }

        @Override
        public void remove(Integer key) {
            int hash = key % SIZE;
            nodes[hash] = remove(nodes[hash], key);
        }

        @Override
        public int size() {
            return 0;
        }

        private static ListNode find(ListNode node, int key) {
            if (node == null) return null;
            if (node.key == key) return node;

            return find(node.next, key);
        }

        private static ListNode remove(ListNode node, int key) {
            if (node == null) return null;
            if (node.key == key) return node.next;
            node.next = remove(node.next, key);

            return node;
        }
    }

    public List<String> process() {
        return HashMapHandler.process(operations, new MyHashMap());
    }
}
