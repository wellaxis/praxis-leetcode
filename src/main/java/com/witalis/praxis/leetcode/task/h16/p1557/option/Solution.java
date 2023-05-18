package com.witalis.praxis.leetcode.task.h16.p1557.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1557
 * Name: Minimum Number of Vertices to Reach All Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">Minimum Number of Vertices to Reach All Nodes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;
    private List<List<Integer>> edges;

    public List<Integer> process() {
        return findSmallestSetOfVertices(nodes, edges);
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];

        for (List<Integer> edge : edges)
            ++inDegree[edge.get(1)];

        for (int i = 0; i < inDegree.length; ++i)
            if (inDegree[i] == 0)
                ans.add(i);

        return ans;
    }
}
