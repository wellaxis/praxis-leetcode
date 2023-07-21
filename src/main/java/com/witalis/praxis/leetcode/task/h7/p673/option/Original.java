package com.witalis.praxis.leetcode.task.h7.p673.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 673
 * Name: Number of Longest Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/">Number of Longest Increasing Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Original(int[] numbers) {
        this.numbers = numbers;
    }

    public Integer process() {
        return findNumberOfLIS(numbers);
    }

    static class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private Pair[] dp;

    public int findNumberOfLIS(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        this.dp = new Pair[n];
        dp[0] = new Pair(1, 1);

        for (int i = 1; i < n; i++) {
            dp[i] = new Pair(-1, -1);
            findRecursiveLIS(nums, i);
        }

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i].value) {
                max = dp[i].value;
                count = dp[i].count;
            } else if (max == dp[i].value) {
                count += dp[i].count;
            }
        }

        return count;
    }

    public void findRecursiveLIS(int[] nums, int index) {
        if (dp[index].count != -1) return;

        dp[index].value = 1;
        dp[index].count = 1;
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                findRecursiveLIS(nums, i);
                if (dp[index].value < dp[i].value + 1) {
                    dp[index].value = dp[i].value + 1;
                    dp[index].count = dp[i].count;
                } else if (dp[index].value == dp[i].value + 1) {
                    dp[index].count += dp[i].count;
                }
            }
        }
    }
}
