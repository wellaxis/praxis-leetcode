package com.witalis.praxis.leetcode.task.h18.p1759.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1759
 * Name: Count Number of Homogenous Substrings
 * URL: <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings/">Count Number of Homogenous Substrings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return countHomogenous(string);
    }

    public int countHomogenous(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int MOD = (int) 1e9 + 7;

        long count = 1;

        int sequence = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sequence++;
            } else {
                sequence = 1;
            }
            count = (count + sequence) % MOD;
        }

        return (int) count;
    }
}
