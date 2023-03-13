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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int left;
    private int right;

    public Integer process() {
        return countPrimeSetBits(left, right);
    }

    public int countPrimeSetBits(int left, int right) {
        if (left < 0 || right < 0 || left > right) return 0;

        return (int) IntStream.rangeClosed(left, right)
            .map(Original::bitsCount)
            .filter(Original::isPrime)
            .count();
    }

    private static int bitsCount(int number) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >>> 1;
        }

        return count;
    }

    private static boolean isPrime(int number) {
        return number > 1 &&
            IntStream.iterate(2, i -> i * i <= number, i -> i + 1)
                .noneMatch(divisor -> number % divisor == 0);
    }
}
