package com.witalis.praxis.leetcode.task.h7.p673.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 673
 * Name: Number of Longest Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/">Number of Longest Increasing Subsequence</a>
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

    public Integer process() {
        return findNumberOfLIS(numbers);
    }

    private int[] values;
    private int[] counts;

    public int findNumberOfLIS(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        this.values = new int[n];
        Arrays.fill(values, -1);
        values[0] = 1;

        this.counts = new int[n];
        Arrays.fill(counts, -1);
        counts[0] = 1;

        for (int i = 1; i < n; i++)
            findRecursiveLIS(nums, i);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (max < values[i]) {
                max = values[i];
                count = counts[i];
            } else if (max == values[i]) {
                count += counts[i];
            }
        }

        return count;
    }

    public void findRecursiveLIS(int[] nums, int index) {
        if (counts[index] != -1) return;

        values[index] = 1;
        counts[index] = 1;
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                findRecursiveLIS(nums, i);
                if (values[index] < values[i] + 1) {
                    values[index] = values[i] + 1;
                    counts[index] = counts[i];
                } else if (values[index] == values[i] + 1) {
                    counts[index] += counts[i];
                }
            }
        }
    }
}
