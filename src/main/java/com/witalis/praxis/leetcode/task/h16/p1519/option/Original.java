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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] edges;
    private String labels;

    public int[] process() {
        return countSubTrees(number, edges, labels);
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        if (n <= 0 || edges == null || edges.length == 0 || labels.isEmpty()) return new int[0];

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.putIfAbsent(edge[0], new ArrayList<>());
            tree.putIfAbsent(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[n];
        recursiveCount(tree, 0, -1, labels, ans, new int[26]);

        return ans;
    }

    private void recursiveCount(Map<Integer, List<Integer>> tree, int edge, int parentEdge, String labels, int[] ans, int[] stats) {
        stats[labels.charAt(edge) - 'a']++;
        if (tree.containsKey(edge)) {
            List<Integer> subEdges = tree.getOrDefault(edge, Collections.emptyList());
            for (int subEdge: subEdges) {
                if (subEdge == parentEdge) continue;
                int[] subStats = new int[26];
                recursiveCount(tree, subEdge, edge, labels, ans, subStats);
                for (int i = 0; i < stats.length; i++) stats[i] += subStats[i];
            }
        }
        ans[edge] = stats[labels.charAt(edge) - 'a'];
    }
}
