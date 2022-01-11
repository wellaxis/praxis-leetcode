package com.witalis.praxis.leetcode.task.h1.p7.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 9
 * Name: Palindrome Number
 * URL: https://leetcode.com/problems/palindrome-number/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return reverse(number);
    }

    public int reverse(int x) {
        int res = 0;

        int tmp = Math.abs(x);
        while (tmp > 0) {
            if ((int) (Math.log10(res) + 1) < 9) {
                res = res * 10 + tmp % 10;
            } else {
                try {
                    int num = res;
                    for (int i = 0; i < 9; i++) {
                        res = Math.addExact(res, num);
                    }
                    res = Math.addExact(res, tmp % 10);
                } catch (ArithmeticException e) {
                    return 0;
                }
            }
            tmp /= 10;
        }

        if (x < 0) res *= -1;

        return res;
    }
}
