package com.witalis.praxis.leetcode.task.h4.p310.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 310
 * Name: Minimum Height Trees
 * URL: <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int nodes;
    private int[][] edges;

    public Original(int nodes, int[][] edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Integer> process() {
        return findMinHeightTrees(nodes, edges);
    }

    private Map<Integer, List<Integer>> relations = new HashMap<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0 || edges == null) return Collections.emptyList();
        if (n == 1) return List.of(0);

        for (int[] edge : edges) {
            relations.putIfAbsent(edge[0], new ArrayList<>());
            relations.get(edge[0]).add(edge[1]);
            relations.putIfAbsent(edge[1], new ArrayList<>());
            relations.get(edge[1]).add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        List<Integer> minHeightTrees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = dfs(i, new HashSet<>(), 0);
            if (height <= minHeight) {
                if (height < minHeight) minHeightTrees.clear();
                minHeightTrees.add(i);
                minHeight = height;
            }
        }

        return minHeightTrees;
    }

    private int dfs(int parent, Set<Integer> trees, int height) {
        int parentHeight = height;
        if (!trees.contains(parent) && relations.containsKey(parent)) {
            trees.add(parent);
            for (int child : relations.get(parent)) {
                if (!trees.contains(child) && relations.containsKey(child)) {
                    int childHeight = dfs(child, trees, height + 1);
                    if (childHeight > parentHeight) parentHeight = childHeight;
                }
            }
            trees.remove(parent);
        }

        return parentHeight;
    }
}
