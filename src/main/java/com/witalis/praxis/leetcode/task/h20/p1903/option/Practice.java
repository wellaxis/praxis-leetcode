package com.witalis.praxis.leetcode.task.h20.p1903.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1903
 * Name: Largest Odd Number in String
 * URL: <a href="https://leetcode.com/problems/largest-odd-number-in-string/">Largest Odd Number in String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String number;

    public String process() {
        return largestOddNumber(number);
    }

    public String largestOddNumber(String num) {
        if (num == null || num.isEmpty()) return num;

        final char[] digits = num.toCharArray();
        for (int i = digits.length - 1; i >= 0; i--)
            if ((digits[i] & 1) != 0)
                return num.substring(0, i + 1);

        return "";
    }
}
