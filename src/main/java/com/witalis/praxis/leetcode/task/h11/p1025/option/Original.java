package com.witalis.praxis.leetcode.task.h11.p1025.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1025
 * Name: Divisor Game
 * URL: <a href="https://leetcode.com/problems/divisor-game/">Divisor Game</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Boolean process() {
        return divisorGame(number);
    }

    public boolean divisorGame(int n) {
        if (n <= 0) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (dp[i - j] == false) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
