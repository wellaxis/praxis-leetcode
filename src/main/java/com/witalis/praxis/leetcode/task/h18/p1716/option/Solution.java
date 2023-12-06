package com.witalis.praxis.leetcode.task.h18.p1716.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1716
 * Name: Calculate Money in Leetcode Bank
 * URL: <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank/">Calculate Money in Leetcode Bank</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return totalMoney(number);
    }

    public int totalMoney(int n) {
        if (n <= 7) return n * (n + 1) / 2;

        int count = n / 7;
        int mod = n % 7;
        return count * 28 + 7 * ((count - 1) * count / 2) + ((mod * (mod + 1)) / 2) + count * mod;
    }
}
