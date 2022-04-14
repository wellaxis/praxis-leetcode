package com.witalis.praxis.leetcode.task.h4.p342.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 342
 * Name: Power of Four
 * URL: <a href="https://leetcode.com/problems/power-of-four/">https://leetcode.com/problems/power-of-four/</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isPowerOfFour(number);
    }

    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        while (n % 4 == 0) n >>= 2;

        return n == 1;
    }
}
