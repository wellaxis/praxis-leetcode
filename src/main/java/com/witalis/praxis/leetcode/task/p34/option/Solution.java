package com.witalis.praxis.leetcode.task.p34.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 34
 * Name: Find First and Last Position of Element in Sorted Array
 * URL: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public int[] process() {
        return searchRange(numbers, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int first = l;
        if (l < nums.length && nums[l] == target) {
            //l is in boundary and is the target
            l = 0;
            r = nums.length - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }

            return new int[] {first, r};
        }

        return new int[] {-1, -1};
    }
}
