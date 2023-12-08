package com.witalis.praxis.leetcode.task.h25.p2413.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2413
 * Name: Smallest Even Multiple
 * URL: <a href="https://leetcode.com/problems/smallest-even-multiple/">Smallest Even Multiple</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return smallestEvenMultiple(number);
    }

    public int smallestEvenMultiple(int n) {
        if (n <= 0) return 0;
        if (n % 2 == 0) return n;

        return 2 * n;
    }
}
