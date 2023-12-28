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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int removes;

    public Solution(String string, int removes) {
        this.string = string;
        this.removes = removes;
    }

    public Integer process() {
        return getLengthOfOptimalCompression(string, removes);
    }

    private int[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        dp = new int[s.length()][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(s, 0, k);
    }

    private int dfs(String s, int idx, int k) {
        if (idx == s.length() || s.length() - idx <= k) {
            return 0;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }

        int[] count = new int[26];
        int maxFreq = 0;
        int ret = Integer.MAX_VALUE;
        for (int i = idx; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(i) - 'a']);
            if (k >= i - idx + 1 - maxFreq) {
                ret = Math.min(ret, getLen(maxFreq) + 1 + dfs(s, i + 1, k - (i - idx + 1 - maxFreq)));
            }
        }

        return dp[idx][k] = ret;
    }

    private static int getLen(int num) {
        return num == 1 ? 0 : num < 10 ? 1 : num < 100 ? 2 : 3;
    }
}
