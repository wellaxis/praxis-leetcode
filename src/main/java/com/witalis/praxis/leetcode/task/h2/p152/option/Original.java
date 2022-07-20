package com.witalis.praxis.leetcode.task.h2.p152.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 152
 * Name: Maximum Product Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-product-subarray/">Maximum Product Subarray</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxProduct(numbers);
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int product = nums[0];
        int minimum = nums[0];
        int maximum = nums[0];

        int min;
        int max;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            min = Math.min(num, Math.min(num * minimum, num * maximum));
            max = Math.max(num, Math.max(num * minimum, num * maximum));

            product = Math.max(product, Math.max(min, max));

            minimum = min;
            maximum = max;
        }

        return product;
    }
}
