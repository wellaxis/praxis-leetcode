package com.witalis.praxis.leetcode.task.h22.p2140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2140
 * Name: Solving Questions With Brainpower
 * URL: <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">Solving Questions With Brainpower</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] questions;

    public Long process() {
        return mostPoints(questions);
    }

    public long mostPoints(int[][] questions) {
        if (questions == null) return 0L;

        final int n = questions.length;
        final long[] dp = new long[n];

        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            final int points = questions[i][0];
            final int powers = questions[i][1];

            dp[i] = points;
            if (i + powers < n - 1) {
                dp[i] += dp[i + powers + 1];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        return dp[0];
    }
}
