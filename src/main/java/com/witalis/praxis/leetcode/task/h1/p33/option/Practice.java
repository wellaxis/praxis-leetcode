package com.witalis.praxis.leetcode.task.h1.p33.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 33
 * Name: Search in Rotated Sorted Array
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public Integer process() {
        return search(numbers, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;

        return subSearch(nums, target, 0, nums.length - 1);
    }

    private int subSearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return mid;

        if (nums[l] <= nums[mid]) {
            // head is ordered
            if (target >= nums[l] && target < nums[mid]) {
                return subSearch(nums, target, l, mid - 1);
            } else {
                return subSearch(nums, target, mid + 1, r);
            }
        } else {
            // tail is ordered
            if (target > nums[mid] && target <= nums[r]) {
                return subSearch(nums, target, mid + 1, r);
            } else {
                return subSearch(nums, target, l, mid - 1);
            }
        }
    }
}
