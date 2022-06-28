package com.witalis.praxis.leetcode.task.h2.p138.content;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int value) {
        this.val = value;
        this.next = null;
        this.random = null;
    }

    public static Node initList(int[][] nodes) {
        if (nodes == null || nodes.length == 0) return null;

        int len = nodes.length;

        Map<Integer, Node> cache = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            cache.put(i, new Node(nodes[i][0]));
        }

        Node node;
        for (int i = 0; i < len; i++) {
            node = cache.get(i);
            if (i < len - 1) {
                node.next = cache.get(i + 1);
            }
            if (nodes[i][1] >= 0) {
                node.random = cache.get(nodes[i][1]);
            }
        }

        return cache.get(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = this;
        while (current != null) {
            builder.append("[").append(current.val).append(": ");
            if (current.next != null) {
                builder.append(current.next.val);
            } else {
                builder.append("null");
            }
            builder.append("|");
            if (current.random != null) {
                builder.append(current.random.val);
            } else {
                builder.append("null");
            }
            builder.append("]");

            current = current.next;
        }

        return builder.toString();
    }
}
