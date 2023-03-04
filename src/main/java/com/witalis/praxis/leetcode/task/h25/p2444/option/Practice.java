package com.witalis.praxis.leetcode.task.h25.p2444.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2444
 * Name: Count Subarrays With Fixed Bounds
 * URL: <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds/">Count Subarrays With Fixed Bounds</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int minimum;
    private int maximum;

    public Long process() {
        return countSubarrays(numbers, minimum, maximum);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        final int MIN = 0;
        final int MAX = 1;
        final int GAP = 2;

        long count = 0;

        if (nums == null || minK < 0 || maxK < 0) return count;

        final long n = nums.length;
        final long[] indices = new long[] {-1, -1, -1};
        for (int i = 0; i < n; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                indices[MIN] = -1;
                indices[MAX] = -1;
                indices[GAP] = i;
            } else {
                if (nums[i] == minK) indices[MIN] = i;
                if (nums[i] == maxK) indices[MAX] = i;
                if (indices[MIN] != -1 && indices[MAX] != -1) {
                    count += Math.min(indices[MIN], indices[MAX]) - indices[GAP];
                }
            }
        }

        return count;
    }
}
