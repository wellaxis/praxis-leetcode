package com.witalis.praxis.leetcode.task.h23.p2264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2264
 * Name: Largest 3-Same-Digit Number in String
 * URL: <a href="https://leetcode.com/problems/largest-3-same-digit-number-in-string/">Largest 3-Same-Digit Number in String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String number;

    public String process() {
        return largestGoodInteger(number);
    }

    public String largestGoodInteger(String num) {
        if (num == null || num.isEmpty()) return "";

        final char[] letters = num.toCharArray();
        final int n = letters.length;

        char letter = '.';

        int left = 0;
        int right = 0;
        for (int i = 0; i < n - 2; i++) {
            if (letters[i] == letters[i + 1] && letters[i] == letters[i + 2] && (letter <= letters[i])) {
                letter = letters[i];

                left = i;
                right = i + 2;
            }
        }

        return (letter == '.' ) ? "" : num.substring(left, right + 1);
    }
}
