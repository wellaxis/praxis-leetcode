package com.witalis.praxis.leetcode.task.h26.p2551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2551
 * Name: Put Marbles in Bags
 * URL: <a href="https://leetcode.com/problems/put-marbles-in-bags/">Put Marbles in Bags</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] weights;
    private int bags;

    public Long process() {
        return putMarbles(weights, bags);
    }

    public long putMarbles(int[] weights, int k) {
        if (weights == null || k <= 0) return 0L;

        final int n = weights.length;

        final int[] costs = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            costs[i] = weights[i] + weights[i + 1];

        Arrays.sort(costs);

        long maxCost = 0;
        long minCost = 0;
        for (int i = 0; i < k - 1; i++) {
            minCost += costs[i];
            maxCost += costs[n - i - 2];
        }

        return maxCost - minCost;
    }
}
