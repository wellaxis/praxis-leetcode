package com.witalis.praxis.leetcode.task.h15.p1443.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1443
 * Name: Minimum Time to Collect All Apples in a Tree
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">Minimum Time to Collect All Apples in a Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] edges;
    private List<Boolean> hasApple;

    public Integer process() {
        return minTime(number, edges, hasApple);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (n <= 0 || edges == null || edges.length == 0 || hasApple.isEmpty()) return 0;

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.putIfAbsent(edge[0], new ArrayList<>());
            tree.putIfAbsent(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int time = recursiveTime(edges, hasApple, tree, 0, 0);

        return time == 1 ? 0 : time;
    }

    private int recursiveTime(int[][] edges, List<Boolean> hasApple, Map<Integer, List<Integer>> tree, int edge, int parentEdge) {
        if (!tree.containsKey(edge)) {
            return Boolean.TRUE.equals(hasApple.get(edge)) ? 1 : 0;
        }

        int time = 0;
        List<Integer> subEdges = tree.getOrDefault(edge, Collections.emptyList());
        for (int subEdge: subEdges) {
            if (subEdge == parentEdge) continue;
            int subTime = recursiveTime(edges, hasApple, tree, subEdge, edge);
            time += switch (subTime) {
                case 0 -> 0;
                case 1 -> 2;
                default -> subTime + 2;
            };
        }
        if (time == 0 && Boolean.TRUE.equals(hasApple.get(edge))) time = 1;

        return time;
    }
}
