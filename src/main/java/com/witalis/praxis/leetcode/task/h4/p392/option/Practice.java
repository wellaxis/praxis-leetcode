package com.witalis.praxis.leetcode.task.h4.p392.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 392
 * Name: Is Subsequence
 * URL: <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String s;
    private String t;

    public Boolean process() {
        return isSubsequence(s, t);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        int si;
        int ti;
        for (si = 0, ti = 0; si < s.length() && ti < t.length(); si++, ti++) {
            while (ti < t.length() && s.charAt(si) != t.charAt(ti)) ti++;
        }

        return si == s.length() && ti <= t.length();
    }
}
