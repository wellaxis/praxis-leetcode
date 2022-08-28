package com.witalis.praxis.leetcode.task.h3.p213.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 213
 * Name: House Robber II
 * URL: <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return rob(numbers);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;

        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        if (len == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int[] rob1 = new int[len + 1];
        rob1[0] = 0;
        rob1[1] = nums[0];

        int[] rob2 = new int[len + 1];
        rob2[0] = 0;
        rob2[1] = 0;

        for (int i = 2; i <= len; i++) {
            rob1[i] = Math.max(nums[i - 1] + rob1[i - 2], rob1[i - 1]);
            rob2[i] = Math.max(nums[i - 1] + rob2[i - 2], rob2[i - 1]);
        }

        return Math.max(rob1[len - 1], rob2[len]);
    }
}
