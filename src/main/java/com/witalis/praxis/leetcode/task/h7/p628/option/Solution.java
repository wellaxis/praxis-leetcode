package com.witalis.praxis.leetcode.task.h7.p628.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 628
 * Name: Maximum Product of Three Numbers
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/">Maximum Product of Three Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maximumProduct(numbers);
    }

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {
                // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                // n lies between max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                // n lies between max2 and max3
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
