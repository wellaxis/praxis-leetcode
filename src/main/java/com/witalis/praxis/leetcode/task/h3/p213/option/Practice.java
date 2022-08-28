package com.witalis.praxis.leetcode.task.h3.p213.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 213
 * Name: House Robber II
 * URL: <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return rob(numbers);
    }

    public int rob(int[] nums) {
        if (nums == null) return 0;

        int len = nums.length;

        if (len <= 3) return Arrays.stream(nums).max().orElse(0);

        int[] rob1 = new int[len + 1];
        Arrays.fill(rob1, 0);
        rob1[1] = nums[0];

        int[] rob2 = new int[len + 1];
        Arrays.fill(rob2, 0);

        robbery(nums, rob1);
        robbery(nums, rob2);

        return Math.max(rob1[len - 1], rob2[len]);
    }

    private void robbery(int[] nums, int[] robs) {
        int len = nums.length;

        for (int i = 2; i <= len; i++) {
            robs[i] = Math.max(nums[i - 1] + robs[i - 2], robs[i - 1]);
        }
    }
}
