package com.witalis.praxis.leetcode.task.h6.p540.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 540
 * Name: Single Element in a Sorted Array
 * URL: <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Single Element in a Sorted Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return singleNonDuplicate(numbers);
    }

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (end == 0) return nums[0];
        if (nums[start] != nums[start + 1]) return nums[start];
        if (nums[end] != nums[end - 1]) return nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];

            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (nums[mid] == nums[mid - 1]) {
                int t = mid - 1;
                if (t % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
