package com.witalis.praxis.leetcode.task.h1.p5.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 5
 * Name: Longest Palindromic Substring
 * URL: https://leetcode.com/problems/longest-palindromic-substring/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return longestPalindrome(string);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        var beginIndex = 0;
        var endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            var palindrome = positionPalindrome(s, i);
            if ((palindrome[1] - palindrome[0]) > (endIndex - beginIndex)) {
                beginIndex = palindrome[0];
                endIndex = palindrome[1];
            }
        }

        return s.substring(beginIndex, endIndex + 1);
    }

    public int[] positionPalindrome(String s, int position) {
        int beginIndex;
        int endIndex;

        // mirror
        beginIndex = position;
        endIndex = position;
        while (beginIndex >= 0 && endIndex < s.length() && s.charAt(beginIndex) == s.charAt(endIndex)) {
            beginIndex--;
            endIndex++;
        }
        var mirror = new int[] {beginIndex + 1, endIndex - 1};

        // offset
        beginIndex = position;
        endIndex = position + 1;
        while (beginIndex >= 0 && endIndex < s.length() && s.charAt(beginIndex) == s.charAt(endIndex)) {
            beginIndex--;
            endIndex++;
        }
        var offset = new int[] {beginIndex + 1, endIndex - 1};

        // check
        return ((offset[1] - offset[0]) > (mirror[1] - mirror[0])) ? offset : mirror;
    }
}
