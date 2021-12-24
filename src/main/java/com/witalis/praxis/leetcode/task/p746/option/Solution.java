package com.witalis.praxis.leetcode.task.p746.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 746
 * Name: Min Cost Climbing Stairs
 * URL: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] cost;

    public Integer process() {
        return minCostClimbingStairs(cost);
    }

    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        return Math.min(cost[0], cost[1]);
    }
}
