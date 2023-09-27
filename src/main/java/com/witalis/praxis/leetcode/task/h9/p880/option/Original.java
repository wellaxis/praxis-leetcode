package com.witalis.praxis.leetcode.task.h9.p880.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 880
 * Name: Decoded String at Index
 * URL: <a href="https://leetcode.com/problems/decoded-string-at-index/">Decoded String at Index</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int index;

    public String process() {
        return decodeAtIndex(string, index);
    }

    public String decodeAtIndex(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return "";

        final int n = s.length();
        long size = 0;

        for (int i = 0; i < n; i++) {
            char character = s.charAt(i);
            if (Character.isDigit(character)) {
                size *= (character - '0');
            } else {
                size++;
            }
        }

        if (size == 0 || k > size) return "";

        for (int i = n - 1; i >= 0; i--) {
            char character = s.charAt(i);
            k %= size;

            if (k == 0 && Character.isLetter(character)) {
                return Character.toString(character);
            }

            if (Character.isDigit(character)) {
                size /= (character - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}
