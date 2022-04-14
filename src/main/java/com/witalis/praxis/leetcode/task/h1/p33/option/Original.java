package com.witalis.praxis.leetcode.task.h1.p33.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 33
 * Name: Search in Rotated Sorted Array
 * URL: <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
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
        return search(numbers, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;

        return subSearch(nums, target, 0, nums.length - 1);
    }

    private int subSearch(int[] nums, int target, int l, int r) {
        if (l == r) return -1;

        int mid = l + (r - l) / 2;

        if (mid == l || mid == l + 1) {
            if (nums[l] == target) return l;
            if (nums[mid] == target) return mid;
            if (mid == r || mid == r - 1) {
                if (nums[mid] == target) return mid;
                if (nums[r] == target) return r;
                return -1;
            }
        }

        boolean head;
        if (nums[l] < nums[mid]) {
            // head is ordered
            head = (target >= nums[l] && target <= nums[mid]);
        } else {
            // tail is ordered
            head = !(target >= nums[mid] && target <= nums[r]);
        }

        return head
            ? subSearch(nums, target, l, mid)
            : subSearch(nums, target, mid, r);
    }
}
