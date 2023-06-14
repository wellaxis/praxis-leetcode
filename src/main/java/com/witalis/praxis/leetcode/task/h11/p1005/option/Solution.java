package com.witalis.praxis.leetcode.task.h11.p1005.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1005
 * Name: Maximize Sum Of Array After K Negations
 * URL: <a href="https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/">Maximize Sum Of Array After K Negations</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int negations;

    public Integer process() {
        return largestSumAfterKNegations(numbers, negations);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;
        int i = 0;
        for (i = 0; i < nums.length && nums[i] < 0 && k > 0; i++, k--) {
            nums[i] = (-1 * nums[i]);
        }

        Arrays.sort(nums);
        if (k % 2 != 0 && k > 0)
            nums[0] = (-1 * nums[0]);
        for (i = 0; i < nums.length; i++)
            sum += nums[i];

        return sum;
    }
}
