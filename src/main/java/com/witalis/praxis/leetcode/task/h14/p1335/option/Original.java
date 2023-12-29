package com.witalis.praxis.leetcode.task.h14.p1335.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1335
 * Name: Minimum Difficulty of a Job Schedule
 * URL: <a href="https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">Minimum Difficulty of a Job Schedule</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] jobDifficulty;
    private int days;

    public Integer process() {
        return minDifficulty(jobDifficulty, days);
    }

    public static final int LEN = 300;
    public static final int PERIOD = 10;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || d <= 0) return 0;

        final int n = jobDifficulty.length;
        if (n < d) return -1;

        int[][] dp = new int[PERIOD + 2][LEN + 2];
        for (int i = 0; i <= d; i++) {
            Arrays.fill(dp[i], -1);
        }

        int minDifficulty = dfs(jobDifficulty, d, dp, 0);

        return minDifficulty == Integer.MAX_VALUE ? -1 : minDifficulty;
    }

    private int dfs(int[] jobDifficulty, int days, int[][] dp, int index) {
        if (days == 0 && index == jobDifficulty.length) return 0;
        if (days == 0 || index == jobDifficulty.length) return Integer.MAX_VALUE;
        if (dp[days][index] != -1) return dp[days][index];

        int maxDifficulty = 0;
        int minDifficulty = Integer.MAX_VALUE;

        for (int i = index; i < jobDifficulty.length; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            int rest = dfs(jobDifficulty, days - 1, dp, i + 1);
            if (rest != Integer.MAX_VALUE) {
                minDifficulty = Math.min(minDifficulty, maxDifficulty + rest);
            }
        }

        dp[days][index] = minDifficulty;

        return minDifficulty;
    }
}
