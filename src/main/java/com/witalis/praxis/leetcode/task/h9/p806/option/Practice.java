package com.witalis.praxis.leetcode.task.h9.p806.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 806
 * Name: Number of Lines To Write String
 * URL: <a href="https://leetcode.com/problems/number-of-lines-to-write-string/">Number of Lines To Write String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] widths;
    private String string;

    public int[] process() {
        return numberOfLines(widths, string);
    }

    public static final int MAX_LEN = 100;

    public int[] numberOfLines(int[] widths, String s) {
        final int LINES = 0;
        final int PIXELS = 1;

        if (widths == null || s == null) return new int[0];

        final int[] result = new int[] {1, 0};
        for (final char letter : s.toCharArray()) {
            final int width = widths[letter - 'a'];
            if (result[PIXELS] + width <= MAX_LEN) {
                result[PIXELS] += width;
            } else {
                result[LINES]++;
                result[PIXELS] = width;
            }
        }

        return result;
    }
}
