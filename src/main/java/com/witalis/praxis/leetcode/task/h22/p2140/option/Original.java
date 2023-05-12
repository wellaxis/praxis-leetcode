package com.witalis.praxis.leetcode.task.h22.p2140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2140
 * Name: Solving Questions With Brainpower
 * URL: <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">Solving Questions With Brainpower</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] questions;

    public Original(int[][] questions) {
        this.questions = questions;
    }

    public Long process() {
        return mostPoints(questions);
    }

    private long[] dp;

    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        this.dp = new long[n];

        return dfs(questions, 0);
    }

    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) return 0;
        if (dp[i] != 0) return dp[i];

        final int points = questions[i][0];
        final int powers = questions[i][1];

        long solve = dfs(questions, i + 1);
        long skip = points + dfs(questions, i + powers + 1);

        dp[i] = Math.max(solve, skip);

        return dp[i];
    }
}
