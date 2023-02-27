package com.witalis.praxis.leetcode.task.h4.p368.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 368
 * Name: Largest Divisible Subset
 * URL: <a href="https://leetcode.com/problems/largest-divisible-subset/">Largest Divisible Subset</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<Integer> process() {
        return largestDivisibleSubset(numbers);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null) return Collections.emptyList();

        final List<Integer> subset = new LinkedList<>();

        Arrays.sort(nums);

        final int n = nums.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxValue) {
                maxIndex = i;
                maxValue = dp[i];
            }
        }

        int element = nums[maxIndex];
        for (int i = maxIndex; i >= 0 && maxValue > 0; i--) {
            if (element % nums[i] == 0 && maxValue == dp[i]) {
                subset.add(nums[i]);
                element = nums[i];
                maxValue--;
            }
        }

        return subset;
    }
}
