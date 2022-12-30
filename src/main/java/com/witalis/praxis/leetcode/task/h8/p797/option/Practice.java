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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] graph;

    public Practice(int[][] graph) {
        this.graph = graph;
    }

    public List<List<Integer>> process() {
        return allPathsSourceTarget(graph);
    }

    private List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return Collections.emptyList();

        recursiveTraverse(graph, new ArrayList<>(List.of(0)), 0);

        return paths;
    }

    private void recursiveTraverse(int[][] graph, List<Integer> path, int index) {
        if (index == graph.length - 1) {
            paths.add(new ArrayList<>(path));
        } else {
            final int[] nodes = graph[index];
            for (final int node : nodes) {
                path.add(node);
                recursiveTraverse(graph, path, node);
                path.remove(path.size() - 1);
            }
        }
    }
}
