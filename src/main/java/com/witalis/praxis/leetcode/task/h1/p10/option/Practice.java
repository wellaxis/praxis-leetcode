package com.witalis.praxis.leetcode.task.h1.p10.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 10
 * Name: Regular Expression Matching
 * URL: <a href="https://leetcode.com/problems/regular-expression-matching/">Regular Expression Matching</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private String pattern;

    public Boolean process() {
        return isMatch(string, pattern);
    }

    public boolean isMatch(String s, String p) {
        return positionMatch(s, p, 0, 0);
    }

    private boolean positionMatch(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) return true;
        if (pi == p.length()) return false;

        char pc = (pi < p.length()) ? p.charAt(pi) : '-';
        char sc = (si < s.length()) ? s.charAt(si) : '-';

        boolean equality = si < s.length() && (pc == '.' || pc == sc);

        if (pi == p.length() - 1 || p.charAt(pi + 1) != '*') {
            if (equality) {
                // convergence, go ahead
                return positionMatch(s, p, si + 1, pi + 1);
            } else {
                // divergence, exit
                return false;
            }
        } else {
            // absence, for zero
            if (positionMatch(s, p, si, pi + 2)) {
                return true;
            }
            // presence, for non zero
            if (equality && positionMatch(s, p, si + 1, pi)) {
                return true;
            }
        }
        return false;
    }
}
