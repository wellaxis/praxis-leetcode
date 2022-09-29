package com.witalis.praxis.leetcode.task.h7.p628.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 628
 * Name: Maximum Product of Three Numbers
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/">Maximum Product of Three Numbers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maximumProduct(numbers);
    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        int len = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}
