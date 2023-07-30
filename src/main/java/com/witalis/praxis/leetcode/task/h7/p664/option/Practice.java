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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Practice(String string) {
        this.string = string;
    }

    public Integer process() {
        return strangePrinter(string);
    }

    private int[][] dp;

    public int strangePrinter(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();
        this.dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return print(s.toCharArray(), dp, 0, n - 1);
    }

    private int print(char[] letters, int[][] dp, int l, int r) {
        if (dp[l][r] != -1) return dp[l][r];

        int turns;

        if (l == r) {
            turns = 1;
        } else {
            if (letters[l] == letters[r] || letters[r - 1] == letters[r]) {
                turns = print(letters, dp, l, r - 1);
            } else if (letters[l] == letters[l + 1]) {
                turns = print(letters, dp, l + 1, r);
            } else {
                turns = print(letters, dp, l, r - 1) + 1;
                for (int i = l + 1; i < r; i++)
                    if (letters[i] == letters[r])
                        turns = Math.min(turns, print(letters, dp, l, i - 1) + print(letters, dp, i, r - 1));
            }
        }

        dp[l][r] = turns;

        return turns;
    }
}
