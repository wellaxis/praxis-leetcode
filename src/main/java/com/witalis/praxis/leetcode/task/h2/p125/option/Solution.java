package com.witalis.praxis.leetcode.task.h2.p125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 125
 * Name: Valid Palindrome
 * URL: https://leetcode.com/problems/valid-palindrome/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return isPalindrome(string);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            ) {
                i++;
            }

            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))
            ) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
