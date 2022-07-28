package com.witalis.praxis.leetcode.task.h2.p166.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 166
 * Name: Fraction to Recurring Decimal
 * URL: <a href="https://leetcode.com/problems/fraction-to-recurring-decimal/">Fraction to Recurring Decimal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numerator;
    private int denominator;

    public String process() {
        return fractionToDecimal(numerator, denominator);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        final int MAX_LEN = 10_000;

        if (numerator == 0) return "0";
        if (denominator == 0) return "";

        Map<Long, Integer> maps = new HashMap<>();

        long dividend = numerator;
        long divisor = denominator;

        StringBuilder sb = new StringBuilder();
        if (dividend * divisor < 0) sb.append("-");

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend % divisor == 0) return sb.append(dividend / divisor).toString();

        sb.append(dividend / divisor);
        sb.append(".");

        long reminder = dividend % divisor;

        while (reminder != 0) {
            if (sb.length() >= MAX_LEN) break;

            if (maps.containsKey(reminder)) {
                sb.insert(maps.get(reminder), "(").append(")");
                return sb.toString();
            }
            maps.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / divisor);
            reminder %= divisor;
        }

        return sb.toString();
    }
}
