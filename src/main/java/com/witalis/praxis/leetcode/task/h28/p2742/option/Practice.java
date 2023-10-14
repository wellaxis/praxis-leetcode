package com.witalis.praxis.leetcode.task.h28.p2742.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2742
 * Name: Painting the Walls
 * URL: <a href="https://leetcode.com/problems/painting-the-walls/">Painting the Walls</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] costs;
    private int[] times;

    public Integer process() {
        return paintWalls(costs, times);
    }

    public int paintWalls(int[] cost, int[] time) {
        if (cost == null || time == null) return 0;

        final int n = cost.length;
        int[] money = new int[n + 1];

        Arrays.fill(money, (int) 1e9);

        money[0] = 0;
        for (int i = 0; i < n; i++)
            for (int j = n; j > 0; j--)
                money[j] = Math.min(money[j], money[Math.max(j - time[i] - 1, 0)] + cost[i]);

        return money[n];
    }
}
