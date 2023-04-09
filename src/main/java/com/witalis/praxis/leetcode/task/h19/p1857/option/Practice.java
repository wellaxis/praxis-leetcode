package com.witalis.praxis.leetcode.task.h19.p1857.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1857
 * Name: Largest Color Value in a Directed Graph
 * URL: <a href="https://leetcode.com/problems/largest-color-value-in-a-directed-graph/">Largest Color Value in a Directed Graph</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String colors;
    private int[][] edges;

    public Practice(String colors, int[][] edges) {
        this.colors = colors;
        this.edges = edges;
    }

    public Integer process() {
        return largestPathValue(colors, edges);
    }

    static class Node {
        int value;
        char color;
        boolean seen;
        boolean state;
        List<Node> children;
        int[] cache;

        public Node(int value, char color) {
            this.value = value;
            this.color = color;
            this.seen = false;
            this.state = false;
            this.children = new ArrayList<>();
            this.cache = null;
        }
    }

    private Node[] nodes;

    public int largestPathValue(String colors, int[][] edges) {
        if (colors == null || edges == null) return -1;

        final int n = colors.length();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, colors.charAt(i));
        }

        for (final int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
        }

        int maxColorValue = Integer.MIN_VALUE;
        for (final Node node : nodes) {
            if (node.cache == null) {
                int[] stats = pathValue(node);
                if (stats == null) return -1;
                for (int i = 0; i < 26; i++) {
                    maxColorValue = Math.max(maxColorValue, stats[i]);
                }
            }
        }

        return maxColorValue;
    }

    private int[] pathValue(Node node) {
        if (node.cache != null) return node.cache;

        node.seen = true;
        node.state = true;

        int[] stats = new int[26];
        for (final Node child : node.children) {
            if (nodes[child.value].state == true) return null;

            if (!nodes[child.value].seen) {
                int[] childStats = pathValue(child);
                if (childStats == null) return null;
                for (int i = 0; i < 26; i++) {
                    stats[i] = Math.max(stats[i], childStats[i]);
                }
            }
        }
        node.state = false;
        node.seen = false;

        stats[node.color - 'a']++;
        node.cache = stats;

        return stats;
    }
}
