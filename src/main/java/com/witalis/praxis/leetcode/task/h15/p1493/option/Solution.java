package com.witalis.praxis.leetcode.task.h15.p1493.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1493
 * Name: Longest Subarray of 1's After Deleting One Element
 * URL: <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">Longest Subarray of 1's After Deleting One Element</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return longestSubarray(numbers);
    }

    public int longestSubarray(int[] nums) {
        int l = 0;
        int count0 = 0;

        for (final int num : nums) {
            if (num == 0)
                ++count0;
            if (count0 > 1 && nums[l++] == 0)
                --count0;
        }

        return nums.length - l - 1;
    }
}
