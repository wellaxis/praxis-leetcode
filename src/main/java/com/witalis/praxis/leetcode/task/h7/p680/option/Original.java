package com.witalis.praxis.leetcode.task.h7.p680.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 680
 * Name: Valid Palindrome II
 * URL: <a href="https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
                return isPalindrome(s, l) || isPalindrome(s, r);
            }
        }

        return true;
    }

    public boolean isPalindrome(String s, int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == index) continue;
            builder.append(s.charAt(i));
        }

        return builder.toString().equals(builder.reverse().toString());
    }
}
