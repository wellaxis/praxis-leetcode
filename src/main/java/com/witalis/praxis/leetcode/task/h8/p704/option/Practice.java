package com.witalis.praxis.leetcode.task.h8.p704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 704
 * Name: Binary Search
 * URL: <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>
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

        int min = 0;
        int max = nums.length - 1;
        int mid;
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) max = mid - 1;
            else min = mid + 1;
        }

        return -1;
    }
}
