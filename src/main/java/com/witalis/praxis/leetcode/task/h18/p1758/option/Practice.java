package com.witalis.praxis.leetcode.task.h18.p1758.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1758
 * Name: Minimum Changes To Make Alternating Binary String
 * URL: <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/">Minimum Changes To Make Alternating Binary String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return minOperations(string);
    }

    public int minOperations(String s) {
        if (s == null || s.isEmpty()) return 0;

        final char[] digits = s.toCharArray();
        final int n = digits.length;

        int index = 0;

        for (int i = 0; i < n; i++)
            if (i % 2 == 0) {
                if (digits[i] == '1') index++;
            } else {
                if (digits[i] == '0') index++;
            }

        return Math.min(index, n - index);
    }
}
