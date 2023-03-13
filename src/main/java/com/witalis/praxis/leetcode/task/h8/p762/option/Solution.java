package com.witalis.praxis.leetcode.task.h8.p762.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 762
 * Name: Prime Number of Set Bits in Binary Representation
 * URL: <a href="https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime Number of Set Bits in Binary Representation</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int left;
    private int right;

    public Integer process() {
        return countPrimeSetBits(left, right);
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++)
            if (isPrime(getCount(i)))
                count++;

        return count;
    }

    private static int getCount(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= n & (-n);
        }

        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        int c = 2;
        while (c * c <= n) {
            if (n % c == 0)
                return false;
            c++;
        }

        return true;
    }
}
