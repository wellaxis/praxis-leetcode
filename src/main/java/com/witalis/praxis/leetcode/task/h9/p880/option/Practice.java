package com.witalis.praxis.leetcode.task.h9.p880.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 880
 * Name: Decoded String at Index
 * URL: <a href="https://leetcode.com/problems/decoded-string-at-index/">Decoded String at Index</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int index;

    public String process() {
        return decodeAtIndex(string, index);
    }

    public String decodeAtIndex(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return "";

        final char[] letters = s.toCharArray();
        final int n = letters.length;

        long size = 0;
        for (char letter : letters)
            if (Character.isDigit(letter))
                size *= (letter - '0');
            else
                size++;

        if (size == 0 || k > size) return "";

        for (int i = n - 1; i >= 0; i--) {
            k %= size;

            if (k == 0 && Character.isLetter(letters[i]))
                return Character.toString(letters[i]);

            if (Character.isDigit(letters[i]))
                size /= (letters[i] - '0');
            else
                size--;
        }

        return "";
    }
}
