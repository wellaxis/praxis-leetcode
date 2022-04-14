package com.witalis.praxis.leetcode.task.h3.p231.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 231
 * Name: Power of Two
 * URL: <a href="https://leetcode.com/problems/power-of-two/">Power of Two</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return isPowerOfTwo(number);
    }

    public boolean isPowerOfTwo(int n) {
        return isPowerOfTwoBits(n);
    }

    public boolean isPowerOfTwoMath(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;

        return n == 1;
    }

    public boolean isPowerOfTwoBits(int n) {
        // If a number is power of 2,
        // then highly bit is 1 and there is only one 1
        return n > 0 && (n & n - 1) == 0;
    }
}
