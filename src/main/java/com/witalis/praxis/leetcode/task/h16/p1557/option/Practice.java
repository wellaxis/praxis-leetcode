package com.witalis.praxis.leetcode.task.h16.p1557.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1557
 * Name: Minimum Number of Vertices to Reach All Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">Minimum Number of Vertices to Reach All Nodes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nodes;
    private List<List<Integer>> edges;

    public List<Integer> process() {
        return findSmallestSetOfVertices(nodes, edges);
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if (n < 2 || edges == null) return Collections.emptyList();

        final boolean[] degree = new boolean[n];
        for (List<Integer> edge : edges)
            degree[edge.get(1)] = true;

        final List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!degree[i])
                vertices.add(i);

        return vertices;
    }
}
