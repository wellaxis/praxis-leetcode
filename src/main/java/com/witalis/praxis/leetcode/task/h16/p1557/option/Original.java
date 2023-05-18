package com.witalis.praxis.leetcode.task.h16.p1557.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 1557
 * Name: Minimum Number of Vertices to Reach All Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">Minimum Number of Vertices to Reach All Nodes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int nodes;
    private List<List<Integer>> edges;

    public List<Integer> process() {
        return findSmallestSetOfVertices(nodes, edges);
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if (n < 2 || edges == null) return Collections.emptyList();

        int[] degree = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            degree[edges.get(i).get(1)]++;
        }

        List<Integer> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) vertices.add(i);
        }

        return vertices;
    }
}
