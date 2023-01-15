package com.witalis.praxis.leetcode.task.h25.p2421.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2421
 * Name: Number of Good Paths
 * URL: <a href="https://leetcode.com/problems/number-of-good-paths/">Number of Good Paths</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] values;
    private int[][] edges;

    public Integer process() {
        return numberOfGoodPaths(values, edges);
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        if (vals == null || vals.length == 0 || edges == null) return 0;
        int len = vals.length;

        int[] parents = new int[len];
        List<List<Integer>> nodes = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            nodes.add(i, new ArrayList<>());
        }
        for (final int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }

        int[][] nodesData = new int[len][2];
        final Map<Integer, Map<Integer, Integer>> size = new HashMap<>();
        for (int i = 0; i < len; i++) {
            parents[i] = i;
            nodesData[i] = new int[] {vals[i], i};
            size.computeIfAbsent(i, k -> new HashMap<>()).put(vals[i], 1);
        }

        Arrays.sort(nodesData, Comparator.comparingInt(a -> a[0]));
        int goodPaths = len;
        for (var nodeData : nodesData) {
            int value = nodeData[0];
            int index = nodeData[1];
            for (int childIndex : nodes.get(index)) {
                if (vals[childIndex] > value) continue;

                int parentPath = find(parents, index);
                int childPath = find(parents, childIndex);
                if (parentPath != childPath) {
                    goodPaths +=
                        size.get(parentPath).getOrDefault(value, 0) *
                        size.get(childPath).getOrDefault(value, 0);
                    parents[parentPath] = childPath;
                    size.get(childPath).put(
                        value,
                        size.get(childPath).getOrDefault(value, 0) +
                        size.get(parentPath).getOrDefault(value, 0)
                    );
                }
            }
        }

        return goodPaths;
    }

    private static int find(int[] parents, int index) {
        if (parents[index] != index) parents[index] = find(parents, parents[index]);

        return parents[index];
    }
}
