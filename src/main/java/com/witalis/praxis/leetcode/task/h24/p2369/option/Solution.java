package com.witalis.praxis.leetcode.task.h24.p2369.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2369
 * Name: Check if There is a Valid Partition For The Array
 * URL: <a href="https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/">Check if There is a Valid Partition For The Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return validPartition(numbers);
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[3];
        dp[0] = true;

        // determine if prefix array nums[0 ~ i] has a valid partition
        for (int i = 0; i < n; i++) {
            int dpIndex = i + 1;
            boolean ans = false;

            // check 3 possibilities
            if (i > 0 && nums[i] == nums[i - 1]) {
                ans |= dp[(dpIndex - 2) % 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                ans |= dp[(dpIndex - 3) % 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                ans |= dp[(dpIndex - 3) % 3];
            }

            dp[dpIndex % 3] = ans;
        }

        return dp[n % 3];
    }
}
