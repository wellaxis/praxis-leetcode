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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maximumProduct(numbers);
    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        int len = nums.length;
        Arrays.sort(nums);

        int left = nums[0] * nums[1];
        int right = nums[len - 1] * nums[len - 2];

        return Math.max(left * nums[len - 1], right * nums[len - 3]);
    }
}
