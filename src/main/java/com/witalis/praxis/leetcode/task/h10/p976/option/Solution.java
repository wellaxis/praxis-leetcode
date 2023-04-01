package com.witalis.praxis.leetcode.task.h10.p976.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 976
 * Name: Largest Perimeter Triangle
 * URL: <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Largest Perimeter Triangle</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return largestPerimeter(numbers);
    }

    public int largestPerimeter(int[] nums) {
        swapMaxElement(nums, nums.length - 1);
        swapMaxElement(nums, nums.length - 2);
        for (int i = nums.length - 1; i >= 2; i--) {
            swapMaxElement(nums, i - 2);
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    private void swapMaxElement(int[] nums, int index) {
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i <= index; i++)
            if (nums[i] > max)
                max = nums[(maxIndex = i)];
        nums[maxIndex] = nums[index];
        nums[index] = max;
    }
}
