package com.witalis.praxis.leetcode.task.h13.p1221.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1221
 * Name: Split a String in Balanced Strings
 * URL: <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/">Split a String in Balanced Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return balancedStringSplit(string);
    }

    public int balancedStringSplit(String s) {
        if (s == null || s.isEmpty()) return 0;

        int count = 0;

        int lCounter = 0;
        int rCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                rCounter++;
            } else {
                lCounter++;
            }

            if (lCounter == rCounter) {
                count++;
            }
        }

        return count;
    }
}
