package com.witalis.praxis.leetcode.task.h8.p797.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 797
 * Name: All Paths From Source to Target
 * URL: <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">All Paths From Source to Target</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] graph;

    public List<List<Integer>> process() {
        return allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(Arrays.asList(0)), ans);
        return ans;
    }

    private void dfs(int[][] graph, int u, List<Integer> path, List<List<Integer>> ans) {
        if (u == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (final int v : graph[u]) {
            path.add(v);
            dfs(graph, v, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
