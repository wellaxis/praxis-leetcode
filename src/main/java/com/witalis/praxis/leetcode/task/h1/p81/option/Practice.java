package com.witalis.praxis.leetcode.task.h1.p81.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 81
 * Name: Search in Rotated Sorted Array II
 * URL: <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public Boolean process() {
        return search(numbers, target);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                while (left <= right && nums[left] == nums[right]) {
                    if (target == nums[left]) return true;
                    left++;
                    right--;
                }
                if (left > right) return false;
            }

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
