package com.witalis.praxis.leetcode.task.h8.p762.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 762
 * Name: Prime Number of Set Bits in Binary Representation
 * URL: <a href="https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime Number of Set Bits in Binary Representation</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int left;
    private int right;

    public Integer process() {
        return countPrimeSetBits(left, right);
    }

    public int countPrimeSetBits(int left, int right) {
        if (left < 0 || right < 0 || left > right) return 0;

        return (int) IntStream.rangeClosed(left, right)
            .map(Integer::bitCount)
            .filter(Practice::isPrime)
            .count();
    }

    private static boolean isPrime(final int number) {
        if (number <= 1) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
