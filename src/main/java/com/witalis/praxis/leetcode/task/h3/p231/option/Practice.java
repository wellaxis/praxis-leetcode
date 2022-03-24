package com.witalis.praxis.leetcode.task.h3.p231.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 231
 * Name: Power of Two
 * URL: https://leetcode.com/problems/power-of-two/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isPowerOfTwo(number);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        while (n > 2) {
            int t = ((n >> 1) << 1);
            if (n != t) return false;
            n >>= 1;
        }

        return true;
    }
}
