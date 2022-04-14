package com.witalis.praxis.leetcode.task.h1.p44.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 44
 * Name: Wildcard Matching
 * URL: <a href="https://leetcode.com/problems/wildcard-matching/">Wildcard Matching</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private String pattern;

    public Boolean process() {
        return isMatch(string, pattern);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                break;
            }
            f[0][i + 1] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    f[i + 1][j + 1] = f[i][j];
                } else if (p.charAt(j) == '*') {
                    f[i + 1][j + 1] = (f[i + 1][j] || f[i][j] || f[i][j + 1]);
                }
            }
        }

        return f[s.length()][p.length()];
    }
}
