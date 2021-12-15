package com.witalis.praxis.leetcode.task.p69.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 69
 * Name: Sqrt(x)
 * URL: https://leetcode.com/problems/sqrtx/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Integer number;

    public Integer process() {
        return mySqrt(number);
    }

    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;

        int l = 1;
        int r = x / 2;

        while (l < r) {
            int m = (l + r) / 2;

            long multiplication = (long) m * m;

            if (multiplication > x) {
                r = m - 1;
            } else {
                long next = (long) (m + 1) * (m + 1);
                if (next <= x) {
                    l = m + 1;
                } else {
                    return m;
                }
            }
        }

        return l;
    }
}
