package com.witalis.praxis.leetcode.task.h3.p263.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 263
 * Name: Ugly Number
 * URL: https://leetcode.com/problems/ugly-number/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Boolean process() {
        return isUgly(number);
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n > 1) {
            if (n % 5 == 0) {
                n /= 5;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }

        return true;
    }
}
