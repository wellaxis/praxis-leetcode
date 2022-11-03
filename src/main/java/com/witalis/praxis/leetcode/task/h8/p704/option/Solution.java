package com.witalis.praxis.leetcode.task.h8.p704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 704
 * Name: Binary Search
 * URL: <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>
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
        return search(numbers, target);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            return nums[mid] < target
                ? binarySearch(nums, mid + 1, r, target)
                : binarySearch(nums, l, mid - 1, target);
        }

        return -1;
    }
}
