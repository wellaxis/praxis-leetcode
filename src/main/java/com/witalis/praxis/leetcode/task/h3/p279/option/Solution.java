package com.witalis.praxis.leetcode.task.h3.p279.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 279
 * Name: Perfect Squares
 * URL: <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return numSquares(number);
    }

    // Based on Lagrange's Four Square theorem, there are only 4 possible results: 1, 2, 3, 4.
    public int numSquares(int n) {
        if (isSquare(n)) return 1;

        while ((n & 3) == 0) n >>= 2;

        if ((n & 7) == 7) return 4;

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (isSquare(n - i * i)) return 2;
        }

        return 3;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return (sqrt * sqrt == n);
    }
}
