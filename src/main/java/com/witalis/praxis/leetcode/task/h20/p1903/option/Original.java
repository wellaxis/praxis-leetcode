package com.witalis.praxis.leetcode.task.h20.p1903.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1903
 * Name: Largest Odd Number in String
 * URL: <a href="https://leetcode.com/problems/largest-odd-number-in-string/">Largest Odd Number in String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String number;

    public String process() {
        return largestOddNumber(number);
    }

    public String largestOddNumber(String num) {
        if (num == null || num.isEmpty()) return num;

        char[] digits = num.toCharArray();
        int index = digits.length - 1;
        while (index >= 0) {
            if ((digits[index] & 1) != 0) break;
            index--;
        }

        return num.substring(0, index + 1);
    }
}
