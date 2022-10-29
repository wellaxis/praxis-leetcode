package com.witalis.praxis.leetcode.task.h4.p313.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 313
 * Name: Super Ugly Number
 * URL: <a href="https://leetcode.com/problems/super-ugly-number/">Super Ugly Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[] primes;

    public Integer process() {
        return nthSuperUglyNumber(number, primes);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] factors = new int[k];
        System.arraycopy(primes, 0, factors, 0, k);
        int[] indices = new int[k];
        int[] numbers = new int[n];
        numbers[0] = 1;

        int i = 1;
        while (i < n) {
            int min = Integer.MAX_VALUE;
            for (int f = 0; f < k; f++) {
                if (factors[f] > 0) {
                    min = Math.min(min, factors[f]);
                }
            }
            numbers[i] = min;
            for (int f = 0; f < k; f++) {
                if (factors[f] == min) {
                    indices[f]++;
                    factors[f] = numbers[indices[f]] * primes[f];
                }
            }
            i++;
        }

        return numbers[n - 1];
    }
}
