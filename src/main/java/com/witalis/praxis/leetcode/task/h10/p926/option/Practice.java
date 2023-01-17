package com.witalis.praxis.leetcode.task.h10.p926.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 926
 * Name: Flip String to Monotone Increasing
 * URL: <a href="https://leetcode.com/problems/flip-string-to-monotone-increasing/">Flip String to Monotone Increasing</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return minFlipsMonoIncr(string);
    }

    public int minFlipsMonoIncr(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int[] counts = new int[] {0, 0};
        final char[] digits = s.toCharArray();
        for (final char digit : digits) {
            if (digit == '0') counts[0]++;
        }

        int minFlips = counts[0];
        for (final char digit : digits) {
            switch (digit) {
                case '0' -> counts[0]--;
                case '1' -> counts[1]++;
            }
            minFlips = Math.min(minFlips, counts[0] + counts[1]);
        }

        return minFlips;
    }
}
