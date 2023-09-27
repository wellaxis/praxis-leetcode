package com.witalis.praxis.leetcode.task.h9.p880.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 880
 * Name: Decoded String at Index
 * URL: <a href="https://leetcode.com/problems/decoded-string-at-index/">Decoded String at Index</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int index;

    public String process() {
        return decodeAtIndex(string, index);
    }

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (final char c : s.toCharArray())
            if (Character.isDigit(c))
                size *= c - '0';
            else
                ++size;

        if (k > size) return "";

        for (int i = s.length() - 1; i >= 0; --i) {
            k %= size;
            if (k == 0 && Character.isAlphabetic(s.charAt(i)))
                return s.substring(i, i + 1);
            if (Character.isDigit(s.charAt(i)))
                size /= s.charAt(i) - '0';
            else
                --size;
        }

        throw new IllegalArgumentException();
    }
}
