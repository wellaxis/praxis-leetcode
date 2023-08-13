package com.witalis.praxis.leetcode.task.h24.p2369.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2369
 * Name: Check if There is a Valid Partition For The Array
 * URL: <a href="https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/">Check if There is a Valid Partition For The Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Practice(int[] numbers) {
        this.numbers = numbers;
    }

    public Boolean process() {
        return validPartition(numbers);
    }

    private Boolean[] dp;

    public boolean validPartition(int[] nums) {
        if (nums == null) return false;

        this.dp = new Boolean[nums.length];

        return solve(nums, 0);
    }

    private boolean solve(int[] nums, int index) {
        final int n = nums.length;

        if (index == n) return true;
        if (dp[index] != null) return dp[index];

        boolean valid = false;

        if (index + 1 < n && nums[index] == nums[index + 1] && (solve(nums, index + 2)))
            return dp[index] = true;

        if (index + 2 < n && nums[index] == nums[index + 1] && nums[index] == nums[index + 2] && (solve(nums, index + 3)))
            return dp[index] = true;

        if (index + 2 < n && nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2] && solve(nums, index + 3))
            return dp[index] = true;

        dp[index] = valid;

        return valid;
    }
}
