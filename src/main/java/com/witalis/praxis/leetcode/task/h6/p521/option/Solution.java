package com.witalis.praxis.leetcode.task.h6.p521.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 521
 * Name: Longest Uncommon Subsequence I
 * URL: <a href="https://leetcode.com/problems/longest-uncommon-subsequence-i/">Longest Uncommon Subsequence I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String a;
    private String b;

    public Integer process() {
        return findLUSlength(a, b);
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;

        return Math.max(a.length(), b.length());
    }
}
