package com.witalis.praxis.leetcode.task.h20.p1913.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1913
 * Name: Maximum Product Difference Between Two Pairs
 * URL: <a href="https://leetcode.com/problems/maximum-product-difference-between-two-pairs/">Maximum Product Difference Between Two Pairs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maxProductDifference(numbers);
    }

    public int maxProductDifference(int[] nums) {
        if (nums == null) return 0;

        int min1 = Integer.MAX_VALUE - 1;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE + 1;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return max1 * max2 - min1 * min2;
    }
}
