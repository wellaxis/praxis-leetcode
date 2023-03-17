package com.witalis.praxis.leetcode.task.h9.p806.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 806
 * Name: Number of Lines To Write String
 * URL: <a href="https://leetcode.com/problems/number-of-lines-to-write-string/">Number of Lines To Write String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] widths;
    private String string;

    public int[] process() {
        return numberOfLines(widths, string);
    }

    public int[] numberOfLines(int[] widths, String s) {
        final int MAX_LEN = 100;

        if (widths == null || s == null) return new int[0];

        int lines = 1;
        int pixels = 0;

        for (char letter : s.toCharArray()) {
            int len = widths[letter - 'a'];
            if (pixels + len <= MAX_LEN) {
                pixels += len;
            } else {
                lines++;
                pixels = len;
            }
        }

        return new int[] {lines, pixels};
    }
}
