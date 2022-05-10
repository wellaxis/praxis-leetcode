package com.witalis.praxis.leetcode.task.h3.p238.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 238
 * Name: Product of Array Except Self
 * URL: <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return productExceptSelf(numbers);
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            prefix[i - 1] *= suffix[i - 1];
        }
        prefix[nums.length - 1] *= suffix[nums.length - 1];

        return prefix;
    }
}
