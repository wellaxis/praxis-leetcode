package com.witalis.praxis.leetcode.task.h2.p162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 162
 * Name: Find Peak Element
 * URL: <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findPeakElement(numbers);
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int left = 0;
        int right = n - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left == n - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
