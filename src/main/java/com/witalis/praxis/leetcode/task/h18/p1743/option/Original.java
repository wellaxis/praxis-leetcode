package com.witalis.praxis.leetcode.task.h18.p1743.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1743
 * Name: Restore the Array From Adjacent Pairs
 * URL: <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/">Restore the Array From Adjacent Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] pairs;

    public Original(int[][] pairs) {
        this.pairs = pairs;
    }

    public int[] process() {
        return restoreArray(pairs);
    }

    private Map<Integer, List<Integer>> graph;
    private int[] array;

    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs == null) return new int[0];

        this.graph = new HashMap<>();

        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if (!graph.containsKey(x))
                graph.put(x, new ArrayList<>());
            if (!graph.containsKey(y))
                graph.put(y, new ArrayList<>());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = 0;
        for (var entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                root = entry.getKey();
                break;
            }
        }

        this.array = new int[graph.size()];

        dfs(root, Integer.MAX_VALUE, 0);

        return array;
    }

    private void dfs(int node, int prev, int i) {
        array[i] = node;

        for (int neighbor : graph.get(node))
            if (neighbor != prev)
                dfs(neighbor, node, i + 1);
    }
}
