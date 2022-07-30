package com.witalis.praxis.leetcode.task.h2.p172.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 172
 * Name: Factorial Trailing Zeroes
 * URL: <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">Factorial Trailing Zeroes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return trailingZeroes(number);
    }

    public int trailingZeroes(int n) {
        if (n == 0) return 0;

        int zeroes = 0;

        for (int i = 5; i <= n; i *= 5) {
            zeroes += n / i;
        }

        return zeroes;
    }
}
