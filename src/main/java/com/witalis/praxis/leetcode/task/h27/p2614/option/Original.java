package com.witalis.praxis.leetcode.task.h27.p2614.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 2614
 * Name: Prime In Diagonal
 * URL: <a href="https://leetcode.com/problems/prime-in-diagonal/">Prime In Diagonal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return diagonalPrime(matrix);
    }

    public int diagonalPrime(int[][] nums) {
        if (nums == null) return 0;

        int n = nums.length;

        int maxPrime = 0;
        for (int i = 0; i < n; i++) {
            int leading = nums[i][i];
            int counter = nums[i][n - 1 - i];

            if (isPrime(leading)) maxPrime = Math.max(maxPrime, leading);
            if (isPrime(counter)) maxPrime = Math.max(maxPrime, counter);
        }

        return maxPrime;
    }

    private static boolean isPrime(int number) {
        return number > 1 &&
            IntStream.iterate(2, i -> i * i <= number, i -> i + 1)
                .noneMatch(divisor -> number % divisor == 0);
    }
}
