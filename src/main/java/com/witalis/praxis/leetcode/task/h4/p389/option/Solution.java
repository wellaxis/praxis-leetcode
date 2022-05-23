package com.witalis.praxis.leetcode.task.h4.p389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 389
 * Name: Find the Difference
 * URL: <a href="https://leetcode.com/problems/find-the-difference/">Find the Difference</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String s;
    private String t;

    public Character process() {
        return findTheDifference(s, t);
    }

    public char findTheDifference(String s, String t) {
        int n = s.length();

        char c = t.charAt(n);
        for (int i = 0; i < n; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }

        return c;
    }
}
