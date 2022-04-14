package com.witalis.praxis.leetcode.task.h6.p509.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 509
 * Name: Fibonacci Number
 * URL: <a href="https://leetcode.com/problems/fibonacci-number/">Fibonacci Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return fib(number);
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public int fibFormula(int n) {
        final double sqrt5 = Math.sqrt(5);

        return (int) ((Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n)) / sqrt5);
    }
}
