package com.witalis.praxis.leetcode.task.h23.p2264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2264
 * Name: Largest 3-Same-Digit Number in String
 * URL: <a href="https://leetcode.com/problems/largest-3-same-digit-number-in-string/">Largest 3-Same-Digit Number in String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String number;

    public String process() {
        return largestGoodInteger(number);
    }

    public String largestGoodInteger(String num) {
        char maxDigit = '\0';

        for (int index = 0; index <= num.length() - 3; ++index) {
            if (num.charAt(index) == num.charAt(index + 1) && num.charAt(index) == num.charAt(index + 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(index));
            }
        }

        return maxDigit == '\0' ? "" : new String(new char[] {maxDigit, maxDigit, maxDigit});
    }
}
