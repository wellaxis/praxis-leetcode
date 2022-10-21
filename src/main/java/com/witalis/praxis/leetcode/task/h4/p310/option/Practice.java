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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nodes;
    private int[][] edges;

    public List<Integer> process() {
        return findMinHeightTrees(nodes, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0 || edges == null) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(0);

        Map<Integer, Set<Integer>> relations = new HashMap<>();
        for (int[] edge : edges) {
            relations.putIfAbsent(edge[0], new HashSet<>());
            relations.get(edge[0]).add(edge[1]);
            relations.putIfAbsent(edge[1], new HashSet<>());
            relations.get(edge[1]).add(edge[0]);
        }

        final List<Integer> singles = new ArrayList<>();
        relations.forEach(
            (parent, children) -> {
                if (children.size() == 1) singles.add(parent);
            }
        );

        List<Integer> leaves = new ArrayList<>(singles);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                if (relations.containsKey(leaf)) {
                    int next = relations.get(leaf).iterator().next();
                    relations.get(next).remove(leaf);
                    if (relations.get(next).size() == 1) nextLeaves.add(next);
                }
            }
            leaves = nextLeaves;
        }

        return leaves;
    }
}
