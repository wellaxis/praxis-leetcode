package com.witalis.praxis.leetcode.task.h2.p133.content;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }

    public Node(int value) {
        this.val = value;
        this.neighbors = new ArrayList<>();
    }

    public Node(int value, List<Node> neighbors) {
        this.val = value;
        this.neighbors = neighbors;
    }

    public void addNeighbor(Node node) {
        if (node != null) {
            neighbors.add(node);
        }
    }

    public static Node initGraph(List<List<Integer>> neighbors) {
        if (neighbors == null || neighbors.isEmpty()) return null;

        int len = neighbors.size();

        List<Node> nodes = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int i = 0; i < len; i++) {
            Node node = nodes.get(i);
            for (int index : neighbors.get(i)) {
                node.addNeighbor(nodes.get(index));
            }
        }

        return nodes.get(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(val).append("]").append(" ");
        builder.append("{");
        if (!neighbors.isEmpty()) {
            String[] values = new String[neighbors.size()];
            for (int i = 0; i < neighbors.size(); i++) {
                values[i] = "" + neighbors.get(i).val;
            }
            builder.append(String.join(",", values));
        }
        builder.append("}");
        return builder.toString();
    }
}
