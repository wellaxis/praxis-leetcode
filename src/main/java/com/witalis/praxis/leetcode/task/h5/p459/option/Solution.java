package com.witalis.praxis.leetcode.task.h5.p459.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 459
 * Name: Repeated Substring Pattern
 * URL: <a href="https://leetcode.com/problems/repeated-substring-pattern/">Repeated Substring Pattern</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return repeatedSubstringPattern(string);
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                if (s.charAt(i - 1) != s.charAt(len - 1)) continue;
                int m = len / i;
                String substring = s.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!substring.equals(s.substring(j * i, i + j * i))) break;
                }
                if (j == m) return true;
            }
        }

        return false;
    }
}
