package com.witalis.praxis.leetcode.task.h12.p1175.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1175
 * Name: Prime Arrangements
 * URL: <a href="https://leetcode.com/problems/prime-arrangements/">Prime Arrangements</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return numPrimeArrangements(number);
    }

    public int numPrimeArrangements(int n) {
        final int kMod = 1_000_000_007;
        final int count = countPrimes(n);

        return (int) ((factorial(count, kMod) * factorial(n - count, kMod)) % kMod);
    }

    private int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);

        for (int i = 0; i * i <= n; ++i)
            if (prime[i])
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;

        int count = 0;

        for (boolean p : prime)
            if (p)
                ++count;

        return count;
    }

    private long factorial(int n, final long kMod) {
        long fact = 1;
        for (int i = 1; i <= n; ++i)
            fact = fact * i % kMod;

        return fact;
    }
}
