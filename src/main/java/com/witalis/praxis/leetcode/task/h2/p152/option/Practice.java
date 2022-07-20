package com.witalis.praxis.leetcode.task.h2.p152.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 152
 * Name: Maximum Product Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-product-subarray/">Maximum Product Subarray</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maxProduct(numbers);
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int product = nums[0];
        int minimum = product;
        int maximum = product;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int max = Math.max(num, Math.max(num * minimum, num * maximum));
            minimum = Math.min(num, Math.min(num * minimum, num * maximum));

            product = Math.max(product, maximum = max);
        }

        return product;
    }
}
