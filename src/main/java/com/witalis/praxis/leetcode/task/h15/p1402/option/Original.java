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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] satisfaction;

    public Integer process() {
        return maxSatisfaction(satisfaction);
    }

    public int maxSatisfaction(int[] satisfaction) {
        if (satisfaction == null) return 0;

        Arrays.sort(satisfaction);

        final int n = satisfaction.length;
        final int[][] dp = new int[n + 1][n + 1];
        for (final int[] item : dp) Arrays.fill(item, -1);

        return recursiveSatisfaction(satisfaction, dp, 0, 1);
    }

    private int recursiveSatisfaction(int[] satisfaction, int[][] dp, int dish, int time) {
        if (dish == satisfaction.length) return 0;
        if (dp[dish][time] != -1) return dp[dish][time];

        int next = satisfaction[dish] * time + recursiveSatisfaction(satisfaction, dp, dish + 1, time + 1);
        int skip = recursiveSatisfaction(satisfaction, dp, dish + 1, time);

        int likeTimeCoefficient = Math.max(next, skip);
        dp[dish][time] = likeTimeCoefficient;

        return likeTimeCoefficient;
    }
}
