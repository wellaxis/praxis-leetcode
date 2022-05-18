package com.witalis.praxis.leetcode.task.h3.p209.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 209
 * Name: Minimum Size Subarray Sum
 * URL: <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public Integer process() {
        return minSubArrayLen(target, numbers);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
