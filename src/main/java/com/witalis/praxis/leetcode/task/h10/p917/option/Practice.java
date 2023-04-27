package com.witalis.praxis.leetcode.task.h10.p917.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 917
 * Name: Reverse Only Letters
 * URL: <a href="https://leetcode.com/problems/reverse-only-letters/">Reverse Only Letters</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return reverseOnlyLetters(string);
    }

    public String reverseOnlyLetters(String s) {
        if (s == null || s.isEmpty()) return s;

        final char[] letters = s.toCharArray();
        final int n = letters.length;

        int l = 0;
        int r = n - 1;
        char buffer;
        while (l < r) {
            while (l < n && !Character.isLetter(letters[l])) l++;
            while (r >= 0 && !Character.isLetter(letters[r])) r--;

            if (l >= r) break;

            buffer = letters[l];
            letters[l] = letters[r];
            letters[r] = buffer;

            l++;
            r--;
        }

        return new String(letters);
    }
}
