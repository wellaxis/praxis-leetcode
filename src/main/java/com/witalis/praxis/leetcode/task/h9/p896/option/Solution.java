package com.witalis.praxis.leetcode.task.h9.p896.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 896
 * Name: Monotonic Array
 * URL: <a href="https://leetcode.com/problems/monotonic-array/">Monotonic Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return isMonotonic(numbers);
    }

    public boolean isMonotonic(int[] nums) {
        return increasing(nums) || decreasing(nums);
    }

    public boolean increasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] > nums[i+1]) return false;
        return true;
    }

    public boolean decreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] < nums[i+1]) return false;
        return true;
    }
}
