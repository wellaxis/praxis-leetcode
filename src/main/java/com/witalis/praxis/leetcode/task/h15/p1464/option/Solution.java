package com.witalis.praxis.leetcode.task.h15.p1464.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1464
 * Name: Maximum Product of Two Elements in an Array
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Maximum Product of Two Elements in an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxProduct(numbers);
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int y = nums[nums.length - 2];

        return (x - 1) * (y - 1);
    }
}
