package com.witalis.praxis.leetcode.task.h3.p264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 264
 * Name: Ugly Number II
 * URL: <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return nthUglyNumber(number);
    }

    public int nthUglyNumber(int n) {
        final int F2 = 0;
        final int F3 = 1;
        final int F5 = 2;

        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] factors = new int[3];
        int[] numbers = new int[n];
        numbers[0] = 1;

        for (int i = 1; i < n; i++) {
            int f2Ugly = numbers[factors[F2]] * 2;
            int f3Ugly = numbers[factors[F3]] * 3;
            int f5Ugly = numbers[factors[F5]] * 5;

            int min = Math.min(Math.min(f2Ugly, f3Ugly), f5Ugly);

            if (min == f2Ugly) factors[F2]++;
            if (min == f3Ugly) factors[F3]++;
            if (min == f5Ugly) factors[F5]++;

            numbers[i] = min;
        }

        return numbers[n - 1];
    }
}
