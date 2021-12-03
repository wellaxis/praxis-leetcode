package com.witalis.praxis.leetcode.task.p8.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 8
 * Name: String to Integer (atoi)
 * URL: https://leetcode.com/problems/string-to-integer-atoi/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return myAtoi(string);
    }

    public int myAtoi(String s) {
        if (s == null || s.isBlank()) return 0;

        s = s.trim();

        var sign = (s.charAt(0) == '-') ? -1 : 1;

        var index = 0;
        if (!Character.isDigit(s.charAt(0))) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                index++;
            } else {
                return 0;
            }
        }

        var number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int pop = sign > 0 ? (s.charAt(index) - '0') : ('0' - s.charAt(index));

            int len = (number == 0) ? 1 : (int) (Math.log10(Math.abs(number)) + 1);

            if (len > 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (len >= 9) {
                if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (number < Integer.MIN_VALUE / 10 || (number == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return Integer.MIN_VALUE;
                }
            }

            number = number * 10 + pop;

            index++;
        }

        return number;
    }
}
