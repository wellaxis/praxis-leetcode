package com.witalis.praxis.leetcode.task.p29.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 29
 * Name: Divide Two Integers
 * URL: https://leetcode.com/problems/divide-two-integers/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int dividend;
    private int divisor;

    public Integer process() {
        return divide(dividend, divisor);
    }

    public int divide(int dividend, int divisor) {
        StringBuilder b = new StringBuilder("0");
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

        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);

        if (d1 < d2) return result;
        if (d1 == d2) return negate ? -1 : 1;

        String digits = String.valueOf(d1);
        int len1 = digits.length();

        int index = 0;
        long init = 0;
        while (index < len1) {

            boolean offset = false;
            while (init < d2) {
                if (index == len1) break;
                char next = digits.charAt(index);
                init = Long.parseLong("" + init + next);
                index++;
                if (offset) b.append(0);
                offset = true;
            }

            int sum = 0;
            int counter = 0;
            while (sum + d2 <= init) {
                sum += d2;
                counter++;
            }
            b.append(counter);
            init -= sum;
        }

        result = Integer.parseInt(b.toString());

        return (negate) ? -result : result;
    }
}
