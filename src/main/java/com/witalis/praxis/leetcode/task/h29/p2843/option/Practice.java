package com.witalis.praxis.leetcode.task.h29.p2843.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 2843
 * Name: Count Symmetric Integers
 * URL: <a href="https://leetcode.com/problems/count-symmetric-integers/">Count Symmetric Integers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int low;
    private int high;

    public Integer process() {
        return countSymmetricIntegers(low, high);
    }

    public int countSymmetricIntegers(int low, int high) {
        if (low <= 0 || high <= 0 || low > high) return 0;

        int count = 0;
        for (int i = low; i <= high; i++)
            if (isSymmetric(i))
                count++;

        return count;
    }

    private static boolean isSymmetric(int number) {
        int n = (int) (Math.log10(number) + 1);

        if ((n & 1) != 0) return false;

        int sum = 0;
        int half = n / 2;
        while (n-- > 0) {
            sum += (number % 10) * ((n >= half) ? 1 : -1);
            number /= 10;
        }

        return sum == 0;
    }
}
