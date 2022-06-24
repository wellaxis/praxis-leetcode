package com.witalis.praxis.leetcode.task.h5.p409.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 409
 * Name: Longest Palindrome
 * URL: <a href="https://leetcode.com/problems/longest-palindrome/">Longest Palindrome</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return longestPalindrome(string);
    }

    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        int len = 0;
        for (int i : map) {
            len += i / 2 * 2;
        }
        if (len < s.length()) len++;

        return len;
    }
}
