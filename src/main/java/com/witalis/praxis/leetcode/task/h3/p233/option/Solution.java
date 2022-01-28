package com.witalis.praxis.leetcode.task.h3.p233.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 233
 * Name: Number of Digit One
 * URL: https://leetcode.com/problems/number-of-digit-one/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return countDigitOne(number);
    }

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }

        int m = n;
        int sum = 0;
        int e = 1;

        while (n > 0) {
            int r = n % 10;
            n /= 10;

            if (r == 0) {
                sum += n * e;
            } else if (r > 1) {
                sum += (n + 1) * e;
            } else {
                // r == 1
                sum += m - n * 9 * e - e + 1;
            }

            e *= 10;
        }
        return sum;
    }
}
