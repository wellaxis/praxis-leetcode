package com.witalis.praxis.leetcode.task.h7.p696.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 696
 * Name: Count Binary Substrings
 * URL: <a href="https://leetcode.com/problems/count-binary-substrings/">Count Binary Substrings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return countBinarySubstrings(string);
    }

    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int counter = 0;

        int previous = 0;
        int current = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                counter += Math.min(previous, current);
                previous = current;
                current = 1;
            }
        }
        counter += Math.min(previous, current);

        return counter;
    }
}
