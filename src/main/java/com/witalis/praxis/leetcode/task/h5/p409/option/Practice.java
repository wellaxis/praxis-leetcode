package com.witalis.praxis.leetcode.task.h5.p409.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 409
 * Name: Longest Palindrome
 * URL: <a href="https://leetcode.com/problems/longest-palindrome/">Longest Palindrome</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return longestPalindrome(string);
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] letters = s.toCharArray();
        int[] frequency = new int[26 * 2];

        for (char letter : letters) {
            if (letter <= 'Z') {
                frequency[letter - 'A']++;
            } else {
                frequency[letter - 'a' + 26]++;
            }
        }

        int length = 0;
        for (int qty : frequency) {
            length += ((qty & 1) == 0) ? qty : qty - 1;
        }
        if (length < letters.length) length++;

        return length;
    }
}
