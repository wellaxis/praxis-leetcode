package com.witalis.praxis.leetcode.task.h1.p41.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 41
 * Name: First Missing Positive
 * URL: https://leetcode.com/problems/first-missing-positive/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return firstMissingPositive(numbers);
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > len) break;
                if (nums[i] == nums[nums[i] - 1]) break;
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
