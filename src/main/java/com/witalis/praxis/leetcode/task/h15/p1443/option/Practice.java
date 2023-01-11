package com.witalis.praxis.leetcode.task.h15.p1443.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID: 1443
 * Name: Minimum Time to Collect All Apples in a Tree
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">Minimum Time to Collect All Apples in a Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] edges;
    private List<Boolean> hasApple;

    public Integer process() {
        return minTime(number, edges, hasApple);
    }

    private final Map<Integer, List<Integer>> tree = new HashMap<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (n <= 0 || edges == null || edges.length == 0 || hasApple == null || hasApple.isEmpty()) return 0;

        for (final int[] edge : edges) {
            tree.computeIfAbsent(edge[0], e -> new LinkedList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], e -> new LinkedList<>()).add(edge[0]);
        }

        return recursiveTime(hasApple, 0, -1);
    }

    private int recursiveTime(List<Boolean> hasApple, int edge, int parentEdge) {
        final AtomicInteger time = new AtomicInteger(0);
        tree.getOrDefault(edge, Collections.emptyList()).forEach(
            subEdge -> {
                if (subEdge != parentEdge) {
                    final int subTime = recursiveTime(hasApple, subEdge, edge);
                    if (subTime > 0 || Boolean.TRUE.equals(hasApple.get(subEdge)))
                        time.addAndGet(subTime + 2);

                }
            }
        );

        return time.get();
    }
}
