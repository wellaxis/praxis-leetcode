package com.witalis.praxis.leetcode.task.h18.p1759.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1759
 * Name: Count Number of Homogenous Substrings
 * URL: <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings/">Count Number of Homogenous Substrings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return countHomogenous(string);
    }

    public static final int MOD = 1_000_000_007;

    public int countHomogenous(String s) {
        if (s == null || s.isEmpty()) return 0;

        final char[] letters = s.toCharArray();

        long count = 0;
        char previous = '-';
        int sequence = 0;
        for (char current : letters) {
            if (current == previous)
                sequence++;
            else {
                sequence = 1;
                previous = current;
            }
            count = (count + sequence) % MOD;
        }

        return (int) count;
    }
}
