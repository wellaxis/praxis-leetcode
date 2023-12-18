package com.witalis.praxis.leetcode.task.h20.p1913.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1913
 * Name: Maximum Product Difference Between Two Pairs
 * URL: <a href="https://leetcode.com/problems/maximum-product-difference-between-two-pairs/">Maximum Product Difference Between Two Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxProductDifference(numbers);
    }

    public int maxProductDifference(int[] nums) {
        int[] firstMaxMin = getMaxMin(nums);
        int[] secondMaxMin = getMaxMin(nums);

        return firstMaxMin[0] * secondMaxMin[0] - firstMaxMin[1] * secondMaxMin[1];
    }

    private int[] getMaxMin(int[] nums) {
        final int len = nums.length;

        int maxi = 0;
        int mini = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
            if (nums[i] < min && nums[i] != Integer.MIN_VALUE) {
                min = nums[i];
                mini = i;
            }
        }
        nums[maxi] = Integer.MIN_VALUE;
        nums[mini] = Integer.MIN_VALUE;

        return new int[] {max, min};
    }
}
