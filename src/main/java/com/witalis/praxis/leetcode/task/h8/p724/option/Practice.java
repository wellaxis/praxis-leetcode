package com.witalis.praxis.leetcode.task.h8.p724.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 724
 * Name: Find Pivot Index
 * URL: <a href="https://leetcode.com/problems/find-pivot-index/">Find Pivot Index</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return pivotIndex(numbers);
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int sum = Arrays.stream(nums).sum();
        int accumulator = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (accumulator == sum) return i;
            accumulator += nums[i];
        }

        return -1;
    }
}
