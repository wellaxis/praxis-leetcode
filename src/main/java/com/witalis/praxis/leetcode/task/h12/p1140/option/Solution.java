package com.witalis.praxis.leetcode.task.h12.p1140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1140
 * Name: Stone Game II
 * URL: <a href="https://leetcode.com/problems/stone-game-ii/">Stone Game II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] piles;

    public Solution(int[] piles) {
        this.piles = piles;
    }

    public Integer process() {
        return stoneGameII(piles);
    }

    private int[][] dp;
    private int[] suffixSum;

    public int stoneGameII(int[] piles) {
        final int n = piles.length;

        dp = new int[n][n];
        suffixSum = piles.clone();

        for (int i = n - 2; i >= 0; --i)
            suffixSum[i] += suffixSum[i + 1];

        return gamePlay(0, 1);
    }

    private int gamePlay(int i, int m) {
        if (i + 2 * m >= dp.length) return suffixSum[i];
        if (dp[i][m] > 0) return dp[i][m];

        int opponent = suffixSum[i];

        for (int x = 1; x <= 2 * m; ++x)
            opponent = Math.min(opponent, gamePlay(i + x, Math.max(m, x)));

        return dp[i][m] = suffixSum[i] - opponent;
    }
}
