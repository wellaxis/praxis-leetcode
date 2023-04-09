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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String colors;
    private int[][] edges;

    public Original(String colors, int[][] edges) {
        this.colors = colors;
        this.edges = edges;
    }

    public Integer process() {
        return largestPathValue(colors, edges);
    }

    enum State {
        INIT, WORK, DONE
    }

    static class Node {
        int value;
        char color;
        boolean seen;
        State state;

        public Node(int value, char color) {
            this.value = value;
            this.color = color;
            this.seen = false;
            this.state = State.INIT;
        }
    }

    private Node[] nodes;
    private Map<Node, List<Node>> graph = new HashMap<>();
    private Map<Node, int[]> cache = new HashMap<>();

    public int largestPathValue(String colors, int[][] edges) {
        if (colors == null || edges == null) return -1;

        final int n = colors.length();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, colors.charAt(i));
            graph.put(nodes[i], new ArrayList<>());
        }

        for (final int[] edge : edges) {
            graph.get(nodes[edge[0]]).add(nodes[edge[1]]);
        }

        int maxColorValue = Integer.MIN_VALUE;
        for (final Node node : nodes) {
            if (!cache.containsKey(node)) {
                int[] stats = pathValue(node);
                if (stats == null) return -1;
                int max = Arrays.stream(stats).max().orElse(0);
                maxColorValue = Math.max(maxColorValue, max);
            }
        }

        return maxColorValue;
    }

    private int[] pathValue(Node node) {
        if (cache.containsKey(node)) return cache.get(node);

        node.seen = true;
        node.state = State.WORK;

        int[] stats = new int[26];
        final List<Node> neighbours = graph.get(node);
        for (final Node neighbour : neighbours) {
            if (nodes[neighbour.value].state == State.WORK) {
                return null;
            }
            if (!nodes[neighbour.value].seen) {
                int[] neighbourStats = pathValue(neighbour);
                if (neighbourStats == null) return null;
                for (int i = 0; i < 26; i++) {
                    stats[i] = Math.max(stats[i], neighbourStats[i]);
                }
            }
        }
        node.state = State.DONE;
        node.seen = false;

        stats[node.color - 'a']++;
        cache.put(node, stats);

        return stats;
    }
}
