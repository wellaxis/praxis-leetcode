package com.witalis.praxis.leetcode.task.h7.p680.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 680
 * Name: Valid Palindrome II
 * URL: <a href="https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return validPalindrome(string);
    }

    public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.isBlank()) return true;

        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }

        return true;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        while (begin <= end) {
            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
