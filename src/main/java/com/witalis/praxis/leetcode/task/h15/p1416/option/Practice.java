package com.witalis.praxis.leetcode.task.h15.p1416.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1416
 * Name: Restore The Array
 * URL: <a href="https://leetcode.com/problems/restore-the-array/">Restore The Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int number;

    public Practice(String string, int number) {
        this.string = string;
        this.number = number;
    }

    public Integer process() {
        return numberOfArrays(string, number);
    }

    public static final int MOD = (int) (1e9 + 7);

    private int[] dp;

    public int numberOfArrays(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        this.dp = new int[s.length()];

        return recursiveRestore(s, k, 0);
    }

    private int recursiveRestore(String s, int k, int i) {
        final int n = s.length();

        if (i == n) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != 0) return dp[i];

        for (var j = i; j < n && Long.parseLong(s.substring(i, j + 1)) <= k; j++) {
            dp[i] += recursiveRestore(s, k, j + 1);
            dp[i] %= MOD;
        }

        return dp[i];
    }
}
