package com.witalis.praxis.leetcode.task.h12.p1129.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1129
 * Name: Shortest Path with Alternating Colors
 * URL: <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">Shortest Path with Alternating Colors</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] redEdges;
    private int[][] blueEdges;

    public int[] process() {
        return shortestAlternatingPaths(number, redEdges, blueEdges);
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        return new int[0];
    }
}
