package com.witalis.praxis.leetcode.task.h4.p343.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 343
 * Name: Integer Break
 * URL: <a href="https://leetcode.com/problems/integer-break/">Integer Break</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return integerBreak(number);
    }

    public int integerBreak(int n) {
        if (n <= 3) return n - 1;

        return switch (n % 3) {
            case 0 -> (int) Math.pow(3, (n / 3));
            case 1 -> (int) Math.pow(3, (n - 4) / 3) * 4;
            default -> (int) Math.pow(3, n / 3) * 2;
        };
    }

    public int integerBreakDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }

        return dp[n];
    }
}
