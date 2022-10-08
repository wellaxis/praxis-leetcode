package com.witalis.praxis.leetcode.task.h3.p287.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 287
 * Name: Find the Duplicate Number
 * URL: <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return findDuplicate(numbers);
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int duplicate = -1;

        int low = 1;
        int high = nums.length - 1;

        int mid;
        int count;
        while (low <= high) {
            mid = low + (high - low) / 2;

            count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                duplicate = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return duplicate;
    }
}
