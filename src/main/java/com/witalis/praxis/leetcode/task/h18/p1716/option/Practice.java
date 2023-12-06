package com.witalis.praxis.leetcode.task.h18.p1716.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1716
 * Name: Calculate Money in Leetcode Bank
 * URL: <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank/">Calculate Money in Leetcode Bank</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return totalMoney(number);
    }

    public int totalMoney(int n) {
        if (n <= 0) return 0;

        int total = 0;

        // arithmetic progression: an = a1 + (n - 1) * d; sum = (a1 + an) * n / 2; sum = (2 * a1 + (n - 1) * d) * n / 2

        int weeks = n / 7;
        int days = n % 7;

        total += (56 + (weeks - 1) * 7) * weeks / 2;
        total += (2 * (weeks + 1) + days - 1) * days / 2;

        return total;
    }
}
