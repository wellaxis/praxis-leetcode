package com.witalis.praxis.leetcode.task.h2.p162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 162
 * Name: Find Peak Element
 * URL: <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return findPeakElement(numbers);
    }

    public int findPeakElement(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int left = 1;
        int right = nums.length - 2;

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;

            if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
