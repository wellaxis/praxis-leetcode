package com.witalis.praxis.leetcode.task.h16.p1519.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1519
 * Name: Number of Nodes in the Sub-Tree With the Same Label
 * URL: <a href="https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/">Number of Nodes in the Sub-Tree With the Same Label</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] edges;
    private String labels;

    public Practice(int number, int[][] edges, String labels) {
        this.number = number;
        this.edges = edges;
        this.labels = labels;
    }

    public int[] process() {
        return countSubTrees(number, edges, labels);
    }

    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private int[] answer;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        if (n <= 0 || edges == null || edges.length == 0 || labels == null || labels.isEmpty()) return new int[0];

        answer = new int[n];
        for (final int[] edge : edges) {
            tree.computeIfAbsent(edge[0], e -> new LinkedList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], e -> new LinkedList<>()).add(edge[0]);
        }
        recursiveCount(labels.toCharArray(), 0, -1, new int[26]);

        return answer;
    }

    private int[] recursiveCount(final char[] labels, int edge, int parentEdge, final int[] stats) {
        stats[labels[edge] - 'a']++;
        tree.getOrDefault(edge, Collections.emptyList()).forEach(
            subEdge -> {
                if (subEdge != parentEdge) {
                    final int[] subStats = recursiveCount(labels, subEdge, edge, new int[26]);
                    for (int i = 0; i < stats.length; i++) stats[i] += subStats[i];
                }
            }
        );
        answer[edge] = stats[labels[edge] - 'a'];

        return stats;
    }
}
