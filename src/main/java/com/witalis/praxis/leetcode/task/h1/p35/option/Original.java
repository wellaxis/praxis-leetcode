package com.witalis.praxis.leetcode.task.h1.p35.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 35
 * Name: Search Insert Position
 * URL: <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        if (nums[mid] == target) return mid;

        if (target <= nums[mid]) {
            return searchBinary(nums, target, l, mid - 1);
        } else {
            return searchBinary(nums, target, mid + 1, r);
        }
    }
}
