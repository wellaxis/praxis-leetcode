package com.witalis.praxis.leetcode.task.h2.p198.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 198
 * Name: House Robber
 * URL: <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
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
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[2] += nums[0];
        for (int i = 3; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 3], nums[i - 2]);
        }

        return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    }
}
