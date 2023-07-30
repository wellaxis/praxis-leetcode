package com.witalis.praxis.leetcode.task.h7.p664.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 664
 * Name: Strange Printer
 * URL: <a href="https://leetcode.com/problems/strange-printer/">Strange Printer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return strangePrinter(string);
    }

    public int strangePrinter(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();
        final int[][] dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return print(s, dp, 0, n - 1);
    }

    private int print(String s, int[][] dp, int l, int r) {
        if (dp[l][r] != -1) return dp[l][r];
        if (l == r) {
            dp[l][r] = 1;
            return dp[l][r];
        }

        int turns = 0;
        if (s.charAt(l) == s.charAt(r) || s.charAt(r - 1) == s.charAt(r)) {
            turns = print(s, dp, l, r - 1);
        } else if (s.charAt(l) == s.charAt(l + 1)) {
            turns = print(s, dp, l + 1, r);
        } else {
            turns = print(s, dp, l, r - 1) + 1;
            for (int i = l + 1; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    turns = Math.min(turns, print(s, dp, l, i - 1) + print(s, dp, i, r - 1));
                }
            }
        }
        dp[l][r] = turns;

        return turns;
    }
}
