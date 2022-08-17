package com.witalis.praxis.leetcode.task.h6.p521.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 521
 * Name: Longest Uncommon Subsequence I
 * URL: <a href="https://leetcode.com/problems/longest-uncommon-subsequence-i/">Longest Uncommon Subsequence I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String a;
    private String b;

    public Integer process() {
        return findLUSlength(a, b);
    }

    public int findLUSlength(String a, String b) {
        if (a == null || b == null || a.equals(b)) return -1;

        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int length = 0;

        int ai = 0;
        int bi = 0;
        while (ai < a.length() && bi < b.length()) {
            char ac = a.charAt(ai);
            char bc = b.charAt(bi);
            if (ac != bc) {
                length++;
                ai++;
                bi++;
            }
            bi++;
        }
        if (ai < a.length()) length += a.length() - ai;
        if (bi < b.length()) length += b.length() - bi;

        return length;
    }
}
