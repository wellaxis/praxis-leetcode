package com.witalis.praxis.leetcode.task.h25.p2444.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2444
 * Name: Count Subarrays With Fixed Bounds
 * URL: <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds/">Count Subarrays With Fixed Bounds</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int minimum;
    private int maximum;

    public Long process() {
        return countSubarrays(numbers, minimum, maximum);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;

        int min = -1;
        int max = -1;
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                left = min = max = i;
            }
            min = nums[i] == minK ? i : min;
            max = nums[i] == maxK ? i : max;
            res += Math.min(max, min) - left;
        }

        return res;
    }
}
