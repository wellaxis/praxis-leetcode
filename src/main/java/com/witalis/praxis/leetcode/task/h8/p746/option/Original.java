package com.witalis.praxis.leetcode.task.h8.p746.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 746
 * Name: Min Cost Climbing Stairs
 * URL: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] cost;

    public Integer process() {
        return minCostClimbingStairs(cost);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int oneUp = cost[0];
        int twoUp = cost[1];

        int step = 2;
        while (step < cost.length) {
            int sum = cost[step] + Math.min(oneUp, twoUp);
            oneUp = twoUp;
            twoUp = sum;

            step++;
        }

        return Math.min(oneUp, twoUp);
    }
}
