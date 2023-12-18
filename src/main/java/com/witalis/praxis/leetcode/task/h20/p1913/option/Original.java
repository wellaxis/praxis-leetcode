package com.witalis.praxis.leetcode.task.h20.p1913.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1913
 * Name: Maximum Product Difference Between Two Pairs
 * URL: <a href="https://leetcode.com/problems/maximum-product-difference-between-two-pairs/">Maximum Product Difference Between Two Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxProductDifference(numbers);
    }

    public int maxProductDifference(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        Arrays.sort(nums);

        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
