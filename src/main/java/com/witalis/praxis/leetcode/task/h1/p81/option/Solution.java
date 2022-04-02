package com.witalis.praxis.leetcode.task.h1.p81.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 81
 * Name: Search in Rotated Sorted Array II
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public Boolean process() {
        return search(numbers, target);
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }

            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);
            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);

            if (pivotArray ^ targetArray) {
                // if pivot and target exist in different sorted arrays,
                // recall that xor is true when both operands are distinct
                if (pivotArray) {
                    // pivot in the first, target in the second
                    start = mid + 1;
                } else {
                    // target in the first, pivot in the second
                    end = mid - 1;
                }
            } else {
                // if pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    // target in the second
                    start = mid + 1;
                } else {
                    // target in the first
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}
