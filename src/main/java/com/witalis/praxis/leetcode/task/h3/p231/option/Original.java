package com.witalis.praxis.leetcode.task.h3.p231.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 231
 * Name: Power of Two
 * URL: <a href="https://leetcode.com/problems/power-of-two/">Power of Two</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Boolean process() {
        return isPowerOfTwo(number);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        for (int i = 0; i <= n / 2 && i < 31; i++) {
            int pow = (int) Math.pow(2, i);
            if (pow > n) {
                return false;
            } else if (pow == n) {
                return true;
            }
        }

        return false;
    }
}
