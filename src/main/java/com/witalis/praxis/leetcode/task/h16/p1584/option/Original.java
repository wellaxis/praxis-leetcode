package com.witalis.praxis.leetcode.task.h16.p1584.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1584
 * Name: Min Cost to Connect All Points
 * URL: <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">Min Cost to Connect All Points</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] points;

    public Integer process() {
        return minCostConnectPoints(points);
    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null) return 0;

        int minCost = 0;

        final int n = points.length;
        Set<Integer> path = new HashSet<>();

        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = connectionCost(points[i], points[n - 1]);
        }

        while (path.size() < n) {
            int source = -1;
            for (int target = 0; target < n; target++) {
                if (!path.contains(target)) {
                    if (source == -1 || costs[source] > costs[target]) {
                        source = target;
                    }
                }
            }
            path.add(source);
            minCost += costs[source];
            for (int target = 0; target < n; target++) {
                if (!path.contains(target)) {
                    costs[target] = Math.min(costs[target], connectionCost(points[source], points[target]));
                }
            }
        }

        return minCost;
    }

    private static int connectionCost(int[] source, int[] target) {
        return Math.abs(target[0] - source[0]) + Math.abs(target[1] - source[1]);
    }
}
