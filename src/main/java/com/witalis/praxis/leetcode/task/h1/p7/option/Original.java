package com.witalis.praxis.leetcode.task.h1.p7.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 7
 * Name: Reverse Integer
 * URL: <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return reverse(number);
    }

    public int reverse(int x) {
        long res = 0;

        int tmp = Math.abs(x);
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            tmp /= 10;
        }

        if (x < 0) res *= -1;

        return (int) res;
    }
}
