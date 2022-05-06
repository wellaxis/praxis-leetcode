package com.witalis.praxis.leetcode.task.h3.p204.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 204
 * Name: Count Primes
 * URL: <a href="https://leetcode.com/problems/count-primes/">Count Primes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return countPrimes(number);
    }

    public int countPrimes(int n) {
        if (n <= 1 ) return 0;

        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) counter++;
        }

        return counter;
    }

    private static boolean isPrime(final int number) {
        if (number <= 1) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    private static boolean isPrimeStreamRange(final int number) {
        return number > 1 &&
            IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }

    private static boolean isPrimeStreamIterate(final int number) {
        return number > 1 &&
            IntStream.iterate(2, i -> i * i <= number, i -> i + 1)
            .noneMatch(divisor -> number % divisor == 0);
    }
}
