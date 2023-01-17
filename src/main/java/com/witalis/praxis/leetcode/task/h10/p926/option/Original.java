package com.witalis.praxis.leetcode.task.h10.p926.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 926
 * Name: Flip String to Monotone Increasing
 * URL: <a href="https://leetcode.com/problems/flip-string-to-monotone-increasing/">Flip String to Monotone Increasing</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return minFlipsMonoIncr(string);
    }

    public int minFlipsMonoIncr(String s) {
        if (s == null || s.isEmpty()) return 0;

        int count0s = 0;
        int count1s = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count0s++;
        }

        int minFlips = count0s;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0' -> count0s--;
                case '1' -> count1s++;
            }
            minFlips = Math.min(minFlips, count0s + count1s);
        }

        return minFlips;
    }
}
