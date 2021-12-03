package com.witalis.praxis.leetcode.task.p8.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 8
 * Name: String to Integer (atoi)
 * URL: https://leetcode.com/problems/string-to-integer-atoi/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return myAtoi(string);
    }

    public int myAtoi(String s) {
        // Base condition
        if (s == null || s.length() < 1) {
            return 0;
        }
        // MAX and MIN values for integers
        final int INT_MAX = 2147483647;
        final int INT_MIN = -2147483648;
        // Trimmed string
        s = s.replaceAll("^\\s+", "");
        // Counter
        int i = 0;
        // Flag to indicate if the number is negative
        boolean isNegative = s.startsWith("-");
        // Flag to indicate if the number is positive
        boolean isPositive = s.startsWith("+");
        if (isNegative || isPositive) {
            i++;
        }
        // This will store the converted number
        double number = 0;
        // Loop for each numeric character in the string iff numeric characters are leading
        // characters in the string
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            number = number * 10 + (s.charAt(i) - '0');
            i++;
        }
        // Give back the sign to the converted number
        number = isNegative ? -number : number;
        if (number < INT_MIN) {
            return INT_MIN;
        }
        if (number > INT_MAX) {
            return INT_MAX;
        }
        return (int) number;
    }
}
