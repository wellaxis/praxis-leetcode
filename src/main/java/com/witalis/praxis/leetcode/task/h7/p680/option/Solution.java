package com.witalis.praxis.leetcode.task.h7.p680.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 680
 * Name: Valid Palindrome II
 * URL: <a href="https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return validPalindrome(string);
    }

    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; ++l, --r)
            if (s.charAt(l) != s.charAt(r))
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
        return true;
    }

    private boolean validPalindrome(final String s, int l, int r) {
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }
}
