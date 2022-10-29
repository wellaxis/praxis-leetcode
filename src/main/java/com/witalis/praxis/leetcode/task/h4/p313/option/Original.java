package com.witalis.praxis.leetcode.task.h4.p313.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 313
 * Name: Super Ugly Number
 * URL: <a href="https://leetcode.com/problems/super-ugly-number/">Super Ugly Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        long min;
        long candidate;
        Set<Integer> indices = new HashSet<>();
        for (int i = 1; i < n; i++) {
            min = Long.MAX_VALUE;
            indices.clear();
            for (int j = 0; j < len; j++) {
                candidate = (long) numbers[factors[j]] * primes[j];
                if (candidate <= min) {
                    if (candidate < min) indices.clear();
                    min = candidate;
                    indices.add(j);
                }
            }
            indices.forEach(index -> factors[index]++);
            numbers[i] = (int) min;
        }

        return numbers[n - 1];
    }
}
