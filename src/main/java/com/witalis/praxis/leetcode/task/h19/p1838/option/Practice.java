package com.witalis.praxis.leetcode.task.h19.p1838.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1838
 * Name: Frequency of the Most Frequent Element
 * URL: <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent Element</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int operations;

    public Integer process() {
        return maxFrequency(numbers, operations);
    }

    public int maxFrequency(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0;

        final int n = nums.length;

        Arrays.sort(nums);

        int maxFrequency = 0;

        long sum = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while ((long) nums[r] * (r - l + 1) > sum + k) {
                sum -= nums[l];
                l++;
            }

            maxFrequency = Math.max(maxFrequency, r - l + 1);
        }

        return maxFrequency;
    }
}
