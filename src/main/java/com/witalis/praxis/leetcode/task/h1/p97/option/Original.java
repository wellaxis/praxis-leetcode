package com.witalis.praxis.leetcode.task.h1.p97.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 97
 * Name: Interleaving String
 * URL: https://leetcode.com/problems/interleaving-string/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;
    private String string3;

    public Boolean process() {
        return isInterleave(string1, string2, string3);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i][j] == 1 || dp[i][j - 1] == 1) ? 1 : 0;
                }
            }
        }

        return dp[s1.length()][s2.length()] == 1;
    }
}
