package com.witalis.praxis.leetcode.task.h15.p1416.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1416
 * Name: Restore The Array
 * URL: <a href="https://leetcode.com/problems/restore-the-array/">Restore The Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int number;

    public Integer process() {
        return numberOfArrays(string, number);
    }

    public static final int MOD = (int) (1e9 + 7);

    public int numberOfArrays(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        final int n = s.length();
        int[] dp = new int[n];

        return recursiveRestore(s, k, dp, 0);
    }

    private int recursiveRestore(String s, int k, int[] dp, int i) {
        final int n = s.length();

        if (i == n) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != 0) return dp[i];


        for (var j = i; j < n && Long.parseLong(s.substring(i, j + 1)) <= k; j++) {
            dp[i] += recursiveRestore(s, k, dp, j + 1);
            dp[i] %= MOD;
        }

        return dp[i];
    }
}
