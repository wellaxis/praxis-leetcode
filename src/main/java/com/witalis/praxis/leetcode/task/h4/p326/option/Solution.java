package com.witalis.praxis.leetcode.task.h4.p326.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 326
 * Name: Power of Three
 * URL: <a href="https://leetcode.com/problems/power-of-three/">Power of Three</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return isPowerOfThree(number);
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n % 3 == 0) {
            n /= 3;
            return isPowerOfThree(n);
        }

        return false;
    }

    public boolean isPowerOfThreeRegex(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThreeMath(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThreeLimit(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
