package com.witalis.praxis.leetcode.task.h25.p2466.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2466
 * Name: Count Ways To Build Good Strings
 * URL: <a href="https://leetcode.com/problems/count-ways-to-build-good-strings/">Count Ways To Build Good Strings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int zeroes;
    private int ones;
    private int minLen;
    private int maxLen;

    public Practice(int zeroes, int ones, int minLen, int maxLen) {
        this.zeroes = zeroes;
        this.ones = ones;
        this.minLen = minLen;
        this.maxLen = maxLen;
    }

    public Integer process() {
        return countGoodStrings(minLen, maxLen, zeroes, ones);
    }

    private static final int MOD = 1_000_000_007;

    private int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (low <= 0 || high <= 0 || zero <= 0 || one <= 0) return 0;

        this.dp = new int[high + 1];
        Arrays.fill(dp, -1);

        return recursiveCount(low, high, zero, one, 0);
    }

    private int recursiveCount(int low, int high, int zero, int one, int len) {
        if (len > high) return 0;
        if (dp[len] != -1) return dp[len];

        int count = 0;
        if (low <= len) count++;

        count += recursiveCount(low, high, zero, one, len + zero) % MOD;
        count %= MOD;
        count += recursiveCount(low, high, zero, one, len + one) % MOD;
        count %= MOD;

        dp[len] = count;

        return count;
    }
}
