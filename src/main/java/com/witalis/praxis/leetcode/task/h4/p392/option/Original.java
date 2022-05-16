package com.witalis.praxis.leetcode.task.h4.p392.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 392
 * Name: Is Subsequence
 * URL: <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String s;
    private String t;

    public Boolean process() {
        return isSubsequence(s, t);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            char c = s.charAt(si);
            while (ti < t.length() && c != t.charAt(ti)) ti++;
            si++;
            ti++;
        }

        return si == s.length() && ti <= t.length();
    }
}
