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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int numerator;
    private int denominator;

    public String process() {
        return fractionToDecimal(numerator, denominator);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        if (denominator == 1) return "" + numerator;

        if (numerator % denominator == 0) return String.valueOf((long) numerator / denominator);

        StringBuilder integer = new StringBuilder();

        boolean negate = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);
        if (negate) integer.append("-");

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        long integral = dividend / divisor;
        long fraction = dividend % divisor;

        integer.append(integral);

        StringBuilder decimal = new StringBuilder();
        Map<Long, Integer> reminders = new HashMap<>();

        int index = 0;
        reminders.put(fraction, index);
        fraction *= 10;

        long reminder;
        while (fraction != 0) {
            if (index >= 10_000) break;

            integral = fraction / divisor;
            reminder = fraction % divisor;

            decimal.append(integral);

            if (reminders.containsKey(reminder)) {
                int position = reminders.get(reminder);
                decimal.insert(position, '(');
                decimal.append(')');
                break;
            } else {
                fraction = reminder * 10;
                reminders.put(reminder, ++index);
            }
        }

        return integer.append('.').append(decimal).toString();
    }
}
