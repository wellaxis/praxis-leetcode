package com.witalis.praxis.leetcode.task.h1.p69.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 69
 * Name: Sqrt(x)
 * URL: https://leetcode.com/problems/sqrtx/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Integer number;

    public Integer process() {
        return mySqrt(number);
    }

    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;

        int result = 0;

        int i = 1;
        while (i < x) {
            long multiplication = (long) i * i;
            if (multiplication > x) return result;
            result = i;
            i++;
        }

        return result;
    }
}
