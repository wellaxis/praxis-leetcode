package com.witalis.praxis.leetcode.task.h27.p2614.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2614
 * Name: Prime In Diagonal
 * URL: <a href="https://leetcode.com/problems/prime-in-diagonal/">Prime In Diagonal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public Integer process() {
        return diagonalPrime(matrix);
    }

    public int diagonalPrime(int[][] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        int maxPrime = 0;
        for (int i = 0; i < n; i++) {
            final int leading = nums[i][i];
            final int counter = nums[i][n - 1 - i];

            if (leading > maxPrime && isPrime(leading)) maxPrime = leading;
            if (counter > maxPrime && isPrime(counter)) maxPrime = counter;
        }

        return maxPrime;
    }

    private static boolean isPrime(final int number) {
        if (number <= 1) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
