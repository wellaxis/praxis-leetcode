package com.witalis.praxis.leetcode.task.h6.p590.content;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Definition for a binary tree node.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
        this.val = 0;
        this.children = new ArrayList<>();
    }

    public Node(int value) {
        this.val = value;
        this.children = new ArrayList<>();
    }

    public Node(int value, List<Node> children) {
        this.val = value;
        this.children = children;
    }

    public void addChild(Node node) {
        if (node != null) {
            children.add(node);
        }
    }

    public static Node initTree(int len, int value) {
        final var random = ThreadLocalRandom.current();

        Node root = new Node(random.nextInt(0, value + 1));

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty() && counter < len) {
            Node parent = queue.poll();
            int size = random.nextInt(0, 10);
            for (int i = 0; i < size; i++) {
                Node child = new Node(random.nextInt(0, value + 1));
                parent.addChild(child);
                queue.offer(child);
                counter++;
            }
        }

        return root;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (!children.isEmpty()) {
            builder.append(": {");
            children.forEach(child -> builder.append(child.toString()).append(","));
            builder.deleteCharAt(builder.length() - 1);
            builder.append("}");
        }

        return builder.toString();
    }
}
