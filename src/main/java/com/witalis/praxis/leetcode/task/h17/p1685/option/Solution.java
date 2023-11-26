package com.witalis.praxis.leetcode.task.h17.p1685.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1685
 * Name: Sum of Absolute Differences in a Sorted Array
 * URL: <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/">Sum of Absolute Differences in a Sorted Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return getSumAbsoluteDifferences(numbers);
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int left = 0;
        int right = sum;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            right -= n;

            result[i] = n * i - left + right - n * (nums.length - i - 1);

            left += n;
        }

        return result;
    }
}
