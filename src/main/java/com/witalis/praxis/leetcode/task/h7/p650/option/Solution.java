package com.witalis.praxis.leetcode.task.h7.p650.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 650
 * Name: 2 Keys Keyboard
 * URL: <a href="https://leetcode.com/problems/2-keys-keyboard/">2 Keys Keyboard</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return minSteps(number);
    }

    // math algorithm
    public int minSteps(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }

    // dynamic programming
    public int dpMinSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }

            }
        }
        return dp[n];
    }

    // recursive solution
    public int recursiveMinSteps(int n) {
        if (n == 1) return 0;
        int res = n;
        for (int i = n - 1; i > 1; --i) {
            if (n % i == 0) {
                res = Math.min(res, minSteps(n / i) + i);
            }
        }
        return res;
    }
}
