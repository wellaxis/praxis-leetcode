package com.witalis.praxis.leetcode.task.h6.p540.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 540
 * Name: Single Element in a Sorted Array
 * URL: <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Single Element in a Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return singleNonDuplicate(numbers);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null) return -1;

        final int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int min = 0;
        int max = n - 1;
        int mid;
        while (min <= max) {
            mid = min + (max - min) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (((mid % 2) == 0 && nums[mid] == nums[mid + 1]) || ((mid % 2) != 0 && nums[mid] == nums[mid - 1])) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }
}
