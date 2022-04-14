package com.witalis.praxis.leetcode.task.h4.p342.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 342
 * Name: Power of Four
 * URL: <a href="https://leetcode.com/problems/power-of-four/">https://leetcode.com/problems/power-of-four/</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return isPowerOfFour(number);
    }

    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n % 4 == 0) return isPowerOfFour(n / 4);

        return false;
    }

    public boolean isPowerOfFourMath(int n) {
        if (n == 0) return false;

        int pow = (int) (Math.log(n) / Math.log(4));

        return n == Math.pow(4, pow);
    }
}
