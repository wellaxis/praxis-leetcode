package com.witalis.praxis.leetcode.task.h5.p446.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 446
 * Name: Arithmetic Slices II - Subsequence
 * URL: <a href="https://leetcode.com/problems/arithmetic-slices-ii-subsequence/">Arithmetic Slices II - Subsequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return numberOfArithmeticSlices(numbers);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        int count = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long difference = (long) nums[i] - nums[j];

                if (difference > Integer.MAX_VALUE || difference < Integer.MIN_VALUE) continue;

                int diff = (int) difference;

                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);
                if (dp[j].containsKey(diff)) {
                    dp[i].put(diff, dp[i].get(diff) + dp[j].get(diff));
                    count += dp[j].get(diff);
                }
            }
        }

        return count;
    }
}
