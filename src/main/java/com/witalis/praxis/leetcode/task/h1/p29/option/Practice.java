package com.witalis.praxis.leetcode.task.h1.p29.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 29
 * Name: Divide Two Integers
 * URL: <a href="https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int dividend;
    private int divisor;

    public Integer process() {
        return divide(dividend, divisor);
    }

    public int divide(int dividend, int divisor) {
        int result = 0;

        boolean negate = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        if (longDividend < longDivisor) return result;
        if (longDividend == longDivisor) return negate ? -1 : 1;

        while (longDividend >= longDivisor) {

            int shift = 0;
            while (longDividend >= (longDivisor << shift)) {
                shift++;
            }
            shift--;

            result += 1 << shift;

            longDividend -= longDivisor << shift;
        }

        return (negate) ? -result : result;
    }
}
