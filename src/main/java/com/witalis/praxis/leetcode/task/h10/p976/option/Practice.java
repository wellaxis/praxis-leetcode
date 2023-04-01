package com.witalis.praxis.leetcode.task.h10.p976.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 976
 * Name: Largest Perimeter Triangle
 * URL: <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Largest Perimeter Triangle</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return largestPerimeter(numbers);
    }

    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        final int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i >= 2 && nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }
}
