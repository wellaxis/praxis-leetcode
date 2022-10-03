package com.witalis.praxis.leetcode.task.h3.p279.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 279
 * Name: Perfect Squares
 * URL: <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return numSquares(number);
    }

    public int numSquares(int n) {
        if (n <= 0) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        int current;
        int counter;
        for (int i = 1; i <= n; i++) {
            current = 1;
            counter = Integer.MAX_VALUE;
            while (i >= current * current) {
                counter = Math.min(counter, dp[i - current * current]);
                current++;
            }
            dp[i] += counter;
        }

        return dp[n];
    }
}
