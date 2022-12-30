package com.witalis.praxis.leetcode.task.h8.p797.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 797
 * Name: All Paths From Source to Target
 * URL: <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">All Paths From Source to Target</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] graph;

    public List<List<Integer>> process() {
        return allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return Collections.emptyList();

        List<List<Integer>> paths = new ArrayList<>();
        recursiveTraverse(graph, paths, new ArrayList<>(List.of(0)), 0);

        return paths;
    }

    private void recursiveTraverse(int[][] graph, List<List<Integer>> paths, List<Integer> path, int index) {
        if (index == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        int[] nodes = graph[index];
        for (int i = 0; i < nodes.length; i++) {
            path.add(nodes[i]);
            recursiveTraverse(graph, paths, path, nodes[i]);
            path.remove(path.size() - 1);
        }
    }
}
