package com.witalis.praxis.leetcode.task.h1.p44.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 44
 * Name: Wildcard Matching
 * URL: <a href="https://leetcode.com/problems/wildcard-matching/">Wildcard Matching</a>
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
        return positionMatch(s, p);
    }

    private boolean positionMatch(String s, String p) {
        if (p == null || s == null) return false;
        if (p.length() == 0) return s.length() == 0;

        int si = 0;
        int pi = 0;

        int sia = -1;
        int pia = -1;

        char sc;
        char pc;
        while (si < s.length()) {
            sc = s.charAt(si);
            pc = (pi < p.length()) ? p.charAt(pi) : '-';

            if (pi < p.length() && (pc == '?' || pc == sc)) {
                ++si;
                ++pi;
            } else if (pi < p.length() && pc == '*') {
                pia = pi;
                sia = si;
                pi++;
            } else if (pia != -1) {
                pi = pia + 1;
                si = sia + 1;
                sia++;
            } else {
                return false;
            }
        }

        while (pi < p.length() && p.charAt(pi) == '*') pi++;

        return pi == p.length();
    }
}
