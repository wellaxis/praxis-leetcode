package com.witalis.praxis.leetcode.task.h20.p1903.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1903
 * Name: Largest Odd Number in String
 * URL: <a href="https://leetcode.com/problems/largest-odd-number-in-string/">Largest Odd Number in String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String number;

    public String process() {
        return largestOddNumber(number);
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; --i)
            if ((num.charAt(i) - '0') % 2 == 1)
                return num.substring(0, i + 1);

        return "";
    }
}
