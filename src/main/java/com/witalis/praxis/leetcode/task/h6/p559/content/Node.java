package com.witalis.praxis.leetcode.task.h6.p559.content;

import java.util.ArrayDeque;
import java.util.LinkedList;
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
        this.children = new LinkedList<>();
    }

    public Node(int value) {
        this.val = value;
        this.children = new LinkedList<>();
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

    public static Node initGraph(int totalNodes) {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, totalNodes + 1);
        Queue<Node> nodes = new ArrayDeque<>();

        int counter = 0;
        Node root = new Node(++counter);
        nodes.offer(root);

        Node parent;
        Node child;
        while (len > 0 && !nodes.isEmpty()) {
            parent = nodes.poll();
            int size = random.nextInt(0, 5);
            for (int i = 0; i < size; i++) {
                child = new Node(++counter);
                parent.addChild(child);
                nodes.offer(child);
            }
            len--;
        }

        return root;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (!children.isEmpty()) {
            builder.append(" {");
            String[] values = new String[children.size()];
            for (int i = 0; i < children.size(); i++) {
                values[i] = "" + children.get(i);
            }
            builder.append(String.join(",", values));
            builder.append("}");
        }
        return builder.toString();
    }
}
