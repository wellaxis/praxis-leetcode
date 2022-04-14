package com.witalis.praxis.leetcode.task.h2.p125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 125
 * Name: Valid Palindrome
 * URL: <a href="https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return isPalindrome(string);
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r)))
                r--;

            if (l >= r) break;
            if (s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}
