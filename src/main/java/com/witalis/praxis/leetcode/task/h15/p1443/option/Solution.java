package com.witalis.praxis.leetcode.task.h15.p1443.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1443
 * Name: Minimum Time to Collect All Apples in a Tree
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">Minimum Time to Collect All Apples in a Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] edges;
    private List<Boolean> hasApple;

    public Integer process() {
        return minTime(number, edges, hasApple);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        final int[] counts = new int[n];

        Arrays.sort(
            edges, (a, b) -> {
                if (a[1] == b[0]) {
                    return -1;
                } else if (a[0] == b[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        );

        // walk backwards
        for (int edgePos = edges.length - 1; edgePos >= 0; --edgePos) {
            final int[] edge = edges[edgePos];
            // forward and back + from previous node
            if (hasApple.get(edge[1]) || counts[edge[1]] > 0) {
                counts[edge[0]] += 2 + counts[edge[1]];
            } else if (hasApple.get(edge[0]) || counts[edge[0]] > 0) {
                counts[edge[1]] += 2 + counts[edge[0]];
            }
        }

        return counts[0];
    }
}
