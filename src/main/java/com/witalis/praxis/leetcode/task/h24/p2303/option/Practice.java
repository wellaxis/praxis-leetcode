package com.witalis.praxis.leetcode.task.h24.p2303.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2303
 * Name: Calculate Amount Paid in Taxes
 * URL: <a href="https://leetcode.com/problems/calculate-amount-paid-in-taxes/">Calculate Amount Paid in Taxes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] brackets;
    private int income;

    public Double process() {
        return calculateTax(brackets, income);
    }

    public double calculateTax(int[][] brackets, int income) {
        if (brackets == null || brackets.length == 0 || income <= 0) return 0;

        int base = Math.min(income, brackets[0][0]);
        double tax = base * brackets[0][1] / 100D;
        income -= base;

        for (int i = 1; i < brackets.length && income > 0; i++) {
            base = Math.min(income, brackets[i][0] - brackets[i - 1][0]);
            tax += base * brackets[i][1] / 100D;
            income -= base;
        }

        return tax;
    }
}
