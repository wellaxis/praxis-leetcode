package com.witalis.praxis.leetcode.task.h2.p136.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 136
 * Name: Single Number
 * URL: <a href="https://leetcode.com/problems/single-number/">Single Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return singleNumber(numbers);
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 2;
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return nums[l];
    }
}
