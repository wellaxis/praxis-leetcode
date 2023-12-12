package com.witalis.praxis.leetcode.task.h15.p1464.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1464
 * Name: Maximum Product of Two Elements in an Array
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Maximum Product of Two Elements in an Array</a>
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
        if (nums == null) return 0;

        final int n = nums.length;

        int max1 = Math.max(nums[0], nums[1]);
        int max2 = Math.min(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
