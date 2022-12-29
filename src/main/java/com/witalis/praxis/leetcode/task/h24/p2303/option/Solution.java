package com.witalis.praxis.leetcode.task.h24.p2303.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2303
 * Name: Calculate Amount Paid in Taxes
 * URL: <a href="https://leetcode.com/problems/calculate-amount-paid-in-taxes/">Calculate Amount Paid in Taxes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] brackets;
    private int income;

    public Double process() {
        return calculateTax(brackets, income);
    }

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;

        int previous = 0;
        for (int[] bracket : brackets) {
            if (income < previous) break;

            tax += ((double) (Math.min(income, bracket[0]) - previous) * bracket[1] / 100);
            previous = bracket[0];
        }

        return tax;
    }
}
