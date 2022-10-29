package com.witalis.praxis.leetcode.task.h4.p313.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 313
 * Name: Super Ugly Number
 * URL: <a href="https://leetcode.com/problems/super-ugly-number/">Super Ugly Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[] primes;

    public Integer process() {
        return nthSuperUglyNumber(number, primes);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null || primes.length == 0) return 0;
        if (n == 1) return 1;

        int len = primes.length;
        int[] factors = new int[len];
        int[] numbers = new int[n];
        numbers[0] = 1;

        long[] mins = new long[len];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++) {
                mins[j] = (long) numbers[factors[j]] * primes[j];
            }
            long min = Arrays.stream(mins).min().orElse(0);
            for (int j = 0; j < len; j++) {
                if (min == mins[j]) {
                    factors[j]++;
                }
            }

            numbers[i] = (int) min;
        }

        return numbers[n - 1];
    }
}
