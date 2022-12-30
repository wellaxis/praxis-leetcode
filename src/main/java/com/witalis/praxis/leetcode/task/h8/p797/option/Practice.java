package com.witalis.praxis.leetcode.task.h8.p797.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

    public List<List<Integer>> process() {
        return allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return Collections.emptyList();
    }
}
