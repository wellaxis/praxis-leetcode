package com.witalis.praxis.leetcode.task.h16.p1531.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1531
 * Name: String Compression II
 * URL: <a href="https://leetcode.com/problems/string-compression-ii/">String Compression II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int removes;

    public Integer process() {
        return getLengthOfOptimalCompression(string, removes);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        if (s == null || s.isEmpty() || k < 0) return 0;

        final int n = s.length();
        final int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solver(s, k, dp, 0);
    }

    private int solver(String s, int k, int[][] dp, int i) {
        final int n = s.length();

        if (k < 0) return n;
        if (n <= i + k) return 0;

        int minLength = dp[i][k];
        if (minLength != -1) return minLength;

        minLength = solver(s, k - 1, dp, i + 1);

        int length = 0;
        int same = 0;
        int diff = 0;
        for (int j = i; j < n && diff <= k; j++) {
            if (s.charAt(j) == s.charAt(i)) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++;
            }
            int nextLength = solver(s, k - diff, dp, j + 1);
            minLength = Math.min(minLength, length + nextLength);
        }
        dp[i][k] = minLength;

        return minLength;
    }
}
