package com.witalis.praxis.leetcode.task.h4.p326.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 326
 * Name: Power of Three
 * URL: <a href="https://leetcode.com/problems/power-of-three/">Power of Three</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isPowerOfThree(number);
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        while (n % 3 == 0) n /= 3;

        return n == 1;
    }
}
