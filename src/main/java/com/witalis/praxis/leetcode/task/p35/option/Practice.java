package com.witalis.praxis.leetcode.task.p35.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 35
 * Name: Search Insert Position
 * URL: https://leetcode.com/problems/search-insert-position/
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
        return searchInsert(numbers, target);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        return searchBinary(nums, target, 0, nums.length - 1);
    }

    private int searchBinary(int[] nums, int target, int l, int r) {
        if (l > r) return l;

        int mid = l + (r - l) / 2;

        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }

        return searchBinary(nums, target, l, r);
    }
}
