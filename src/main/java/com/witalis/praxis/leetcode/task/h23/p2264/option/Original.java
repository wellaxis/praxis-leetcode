package com.witalis.praxis.leetcode.task.h23.p2264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2264
 * Name: Largest 3-Same-Digit Number in String
 * URL: <a href="https://leetcode.com/problems/largest-3-same-digit-number-in-string/">Largest 3-Same-Digit Number in String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String number;

    public String process() {
        return largestGoodInteger(number);
    }

    public String largestGoodInteger(String num) {
        if (num == null || num.isEmpty()) return "";

        char letter = '.';

        int left = 0;
        int right = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (letter <= num.charAt(i)) {
                    left = i;
                    right = i + 2;
                    letter = num.charAt(i);
                }
            }
        }
        if (letter != '.') return num.substring(left, right + 1);

        return "";
    }
}
