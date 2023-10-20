package com.witalis.praxis.leetcode.task.h11.p1025.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1025
 * Name: Divisor Game
 * URL: <a href="https://leetcode.com/problems/divisor-game/">Divisor Game</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return divisorGame(number);
    }

    public boolean divisorGame(int n) {
        if (n <= 0) return false;
        if (n == 1) return false;
        if (n == 2) return true;

        boolean[] dp = new boolean[n + 1];

        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                if (i % j == 0 && (!dp[i - j])) {
                    dp[i] = true;
                    break;
                }

        return dp[n];
    }
}
