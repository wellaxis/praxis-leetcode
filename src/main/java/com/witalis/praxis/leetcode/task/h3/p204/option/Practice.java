package com.witalis.praxis.leetcode.task.h3.p204.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 204
 * Name: Count Primes
 * URL: <a href="https://leetcode.com/problems/count-primes/">Count Primes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return countPrimes(number);
    }

    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int counter = 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = 2; i * j < n; j++) {
                    primes[i * j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) counter++;
        }

        return counter;
    }
}
