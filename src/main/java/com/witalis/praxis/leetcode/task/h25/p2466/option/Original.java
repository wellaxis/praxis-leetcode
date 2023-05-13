package com.witalis.praxis.leetcode.task.h25.p2466.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2466
 * Name: Count Ways To Build Good Strings
 * URL: <a href="https://leetcode.com/problems/count-ways-to-build-good-strings/">Count Ways To Build Good Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int zeroes;
    private int ones;
    private int minLen;
    private int maxLen;

    public Original(int zeroes, int ones, int minLen, int maxLen) {
        this.zeroes = zeroes;
        this.ones = ones;
        this.minLen = minLen;
        this.maxLen = maxLen;
    }

    public Integer process() {
        return countGoodStrings(minLen, maxLen, zeroes, ones);
    }

    private static final int MOD = 1_000_000_007;

    private int count = 0;

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (low <= 0 || high <= 0 || zero <= 0 || one <= 0) return 0;

        recursiveCount(low, high, zero, one, 0);

        return count;
    }

    private void recursiveCount(int low, int high, int zero, int one, int len) {
        if (len > high) return;
        if (low <= len) count++;

        recursiveCount(low, high, zero, one, (len + zero) % MOD);
        recursiveCount(low, high, zero, one, (len + one) % MOD);
    }
}
