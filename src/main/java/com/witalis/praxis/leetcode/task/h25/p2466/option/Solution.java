package com.witalis.praxis.leetcode.task.h25.p2466.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2466
 * Name: Count Ways To Build Good Strings
 * URL: <a href="https://leetcode.com/problems/count-ways-to-build-good-strings/">Count Ways To Build Good Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int zeroes;
    private int ones;
    private int minLen;
    private int maxLen;

    public Integer process() {
        return countGoodStrings(minLen, maxLen, zeroes, ones);
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        final int mod = 1000000007;

        final int dp[] = new int[high + 1];
        dp[0] = 1;

        int ans = 0;
        for (int i = 1; i <= high; i++) {
            dp[i] = ((i - zero >= 0 ? dp[i - zero] : 0) + (i - one >= 0 ? dp[i - one] : 0)) % mod;
            if (i >= low) {
                ans = (ans + dp[i]) % mod;
            }
        }

        return ans;
    }
}
