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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int numerator;
    private int denominator;

    public String process() {
        return fractionToDecimal(numerator, denominator);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        final int MAX_LEN = 10_000;

        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        if (denominator == 1) return "" + numerator;

        StringBuilder builder = new StringBuilder();

        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) builder.append("-");

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        long fraction = dividend % divisor;

        builder.append(dividend / divisor);
        if (fraction == 0) {
            return builder.toString();
        } else {
            builder.append('.');
        }

        Map<Long, Integer> reminders = new HashMap<>();

        int index = builder.length();
        reminders.put(fraction, index);
        fraction *= 10;

        long integral;
        long reminder;
        while (builder.length() < MAX_LEN) {
            integral = fraction / divisor;
            reminder = fraction % divisor;

            builder.append(integral);
            if (reminder == 0) return builder.toString();

            if (reminders.containsKey(reminder)) {
                int position = reminders.get(reminder);
                builder.insert(position, '(');
                builder.append(')');
                break;
            } else {
                fraction = reminder * 10;
                reminders.put(reminder, ++index);
            }
        }

        return builder.toString();
    }
}
