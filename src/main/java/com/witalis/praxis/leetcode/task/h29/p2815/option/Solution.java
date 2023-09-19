package com.witalis.praxis.leetcode.task.h29.p2815.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2815
 * Name: Max Pair Sum in an Array
 * URL: <a href="https://leetcode.com/problems/max-pair-sum-in-an-array/">Max Pair Sum in an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxSum(numbers);
    }

    public int maxSum(int[] nums) {
        int max = -1;
        int[] highestValueWithDigit = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

        for (int n : nums) {
            int d = maxDigitOf(n) - 1;
            int m = highestValueWithDigit[d];

            if (m != -1) max = Math.max(max, m + n);

            highestValueWithDigit[d] = Math.max(m, n);
        }

        return max;
    }

    int maxDigitOf(int n) {
        int s = 0;
        while (n > 0) {
            s = Math.max(s, n % 10);
            n /= 10;
        }
        return s;
    }
}
