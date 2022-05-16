package com.witalis.praxis.leetcode.task.h4.p392.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 392
 * Name: Is Subsequence
 * URL: <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String s;
    private String t;

    public Boolean process() {
        return isSubsequence(s, t);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int i = 0;
        int j = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        while (i < ss.length && j < tt.length) {
            if (ss[i] == tt[j]) i++;
            j++;
        }

        return i == s.length();
    }
}
