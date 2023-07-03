package com.witalis.praxis.leetcode.task.h27.p2614.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2614
 * Name: Prime In Diagonal
 * URL: <a href="https://leetcode.com/problems/prime-in-diagonal/">Prime In Diagonal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Integer process() {
        return diagonalPrime(matrix);
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i][i] > max && isPrime(nums[i][i])) {
                max = nums[i][i];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i][nums.length - i - 1] > max && isPrime(nums[i][nums.length - i - 1])) {
                max = nums[i][nums.length - i - 1];
            }
        }

        return max != Integer.MIN_VALUE ? max : 0;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
