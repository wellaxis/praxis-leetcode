package com.witalis.praxis.leetcode.task.h15.p1402.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1402
 * Name: Reducing Dishes
 * URL: <a href="https://leetcode.com/problems/reducing-dishes/">Reducing Dishes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] satisfaction;

    public Practice(int[] satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Integer process() {
        return maxSatisfaction(satisfaction);
    }

    private int[] dishes;
    private int[][] dp;

    public int maxSatisfaction(int[] satisfaction) {
        if (satisfaction == null) return 0;

        final int n = satisfaction.length;
        this.dishes = satisfaction.clone();
        Arrays.sort(dishes);

        this.dp = new int[n + 1][n + 1];
        for (final int[] item : dp) Arrays.fill(item, -1);

        return recursiveSatisfaction(0, 1);
    }

    private int recursiveSatisfaction(int dish, int time) {
        if (dish == dishes.length) return 0;
        if (dp[dish][time] != -1) return dp[dish][time];

        int next = dishes[dish] * time + recursiveSatisfaction(dish + 1, time + 1);
        int skip = recursiveSatisfaction(dish + 1, time);

        dp[dish][time] = Math.max(next, skip);

        return dp[dish][time];
    }
}
