package com.witalis.praxis.leetcode.task.h24.p2369.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2369
 * Name: Check if There is a Valid Partition For The Array
 * URL: <a href="https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/">Check if There is a Valid Partition For The Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return validPartition(numbers);
    }

    public boolean validPartition(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;

        Boolean[] dp = new Boolean[n];

        return solve(nums, dp, 0);
    }

    private boolean solve(int[] nums, Boolean[] dp, int index) {
        final int n = nums.length;

        if (index == n) return true;
        if (dp[index] != null) return dp[index];

        boolean valid = false;
        if (index + 1 < n && nums[index] == nums[index + 1]) {
            valid = solve(nums, dp, index + 2);
            if (valid) {
                dp[index] = valid;
                return valid;
            }
        }

        if (index + 2 < n && nums[index] == nums[index + 1] && nums[index] == nums[index + 2]) {
            valid = solve(nums, dp, index + 3);
            if (valid) {
                dp[index] = valid;
                return valid;
            }
        }

        if (index + 2 < n && nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2]) {
            valid = solve(nums, dp, index + 3);
            if (valid) {
                dp[index] = valid;
                return valid;
            }
        }

        dp[index] = valid;

        return valid;
    }
}
