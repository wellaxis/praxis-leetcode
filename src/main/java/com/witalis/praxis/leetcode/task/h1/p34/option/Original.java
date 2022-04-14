package com.witalis.praxis.leetcode.task.h1.p34.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 34
 * Name: Find First and Last Position of Element in Sorted Array
 * URL: <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public int[] process() {
        return searchRange(numbers, target);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        if (nums.length == 1)
            return (nums[0] == target) ? new int[] {0, 0} : new int[] {-1, -1};

        return searchBinaryRange(nums, target, 0, nums.length - 1);
    }

    private int[] searchBinaryRange(int[] nums, int target, int l, int r) {
        if (l > r) return new int[] {-1, -1};

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) {
            l = mid;
            while (l >= 0 && nums[l] == target) l--;

            r = mid;
            while (r <= nums.length - 1 && nums[r] == target) r++;

            return new int[] {l + 1, r - 1};
        }

        if (target <= nums[mid]) {
            return searchBinaryRange(nums, target, l, mid - 1);
        } else {
            return searchBinaryRange(nums, target, mid + 1, r);
        }
    }
}
