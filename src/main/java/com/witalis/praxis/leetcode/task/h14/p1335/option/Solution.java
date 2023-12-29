package com.witalis.praxis.leetcode.task.h14.p1335.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1335
 * Name: Minimum Difficulty of a Job Schedule
 * URL: <a href="https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">Minimum Difficulty of a Job Schedule</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] jobDifficulty;
    private int days;

    public Integer process() {
        return minDifficulty(jobDifficulty, days);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;

        int len = jobDifficulty.length;
        int sum = 0;
        for (int j : jobDifficulty) sum += j;

        if (sum == 0) return 0;

        int[][] memo = new int[d + 1][len];
        helper(jobDifficulty, d, 0, memo);

        return memo[d][0];
    }

    private void helper(int[] jd, int daysLeft, int idx, int[][] memo) {
        if (memo[daysLeft][idx] != 0) return;

        int len = jd.length;
        if (daysLeft == 1) {
            int num = 0;
            for (int i = idx; i < len; i++) {
                num = Math.max(num, jd[i]);
            }
            memo[daysLeft][idx] = num;
            return;
        }

        int max = jd[idx];
        daysLeft--;
        int stop = len - idx - daysLeft + 1;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < stop; i++) {
            max = Math.max(max, jd[idx + i - 1]);
            int other = memo[daysLeft][idx + i];
            if (other == 0) {
                helper(jd, daysLeft, idx + i, memo);
                other = memo[daysLeft][idx + i];
            }
            res = Math.min(res, other + max);
        }

        memo[daysLeft + 1][idx] = res;
    }
}
