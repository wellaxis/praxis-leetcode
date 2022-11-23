package com.witalis.praxis.leetcode.task.h4.p343.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 343
 * Name: Integer Break
 * URL: <a href="https://leetcode.com/problems/integer-break/">Integer Break</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return integerBreak(number);
    }

    public int integerBreak(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        int product;
        for (int i = 4; i <= n; i++) {
            product = i;
            for (int j = 1; j < i; j++) {
                int s1 = j <= 3 ? j : dp[j];
                int s2 = i - j <= 3 ? i - j : dp[i - j];
                product = Math.max(product, s1 * s2);
            }
            dp[i] = product;
        }

        return dp[n];
    }
}
