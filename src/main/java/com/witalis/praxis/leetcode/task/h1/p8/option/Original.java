package com.witalis.praxis.leetcode.task.h1.p8.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 8
 * Name: String to Integer (atoi)
 * URL: https://leetcode.com/problems/string-to-integer-atoi/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return myAtoi(string);
    }

    public int myAtoi(String s) {
        if (s == null || s.isBlank()) return 0;

        // step #1 - remove leading whitespace
        var atoi = s.trim();

        // step #2 - check negative or positive
        var negative = false;
        var sign = atoi.charAt(0);
        if (sign == '-' || sign == '+') {
            negative = sign == '-';
            atoi = atoi.substring(1);
        }

        // step #3 - read digital number
        var index = 0;
        for (char ch: atoi.toCharArray()) {
            if (!Character.isDigit(ch)) break;
            index++;
        }
        atoi = atoi.substring(0, index);
        if (atoi.isEmpty()) return 0;

        // step #4 - convert string to number
        try {
            return Integer.parseInt(atoi) * ((negative) ? -1 : 1);
        } catch (NumberFormatException e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
