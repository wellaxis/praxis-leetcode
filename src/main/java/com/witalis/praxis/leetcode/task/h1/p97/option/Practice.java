package com.witalis.praxis.leetcode.task.h1.p97.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 97
 * Name: Interleaving String
 * URL: <a href="https://leetcode.com/problems/interleaving-string/">Interleaving String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;
    private String string3;

    public Boolean process() {
        return isInterleave(string1, string2, string3);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s3.charAt(i1 + i2 - 1) == s1.charAt(i1 - 1)) {
                    dp[i1][i2] = dp[i1 - 1][i2];
                }
                if (s3.charAt(i1 + i2 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = dp[i1][i2] || dp[i1][i2 - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
