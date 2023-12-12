package com.witalis.praxis.leetcode.task.h15.p1464.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1464
 * Name: Maximum Product of Two Elements in an Array
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Maximum Product of Two Elements in an Array</a>
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
        if (nums == null) return 0;

        int max1 = 0;
        int max2 = 0;
        for (int num : nums)
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2)
                max2 = num;

        return --max1 * --max2;
    }
}
