package com.witalis.praxis.leetcode.task.h25.p2444.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2444
 * Name: Count Subarrays With Fixed Bounds
 * URL: <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds/">Count Subarrays With Fixed Bounds</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int minimum;
    private int maximum;

    public Long process() {
        return countSubarrays(numbers, minimum, maximum);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (nums == null || minK < 0 || maxK < 0) return 0;

        long count = 0;

        final long n = nums.length;

        long minIndex = -1;
        long maxIndex = -1;
        long previous = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                previous = i;
                minIndex = -1;
                maxIndex = -1;
            } else {
                if (nums[i] == minK) minIndex = i;
                if (nums[i] == maxK) maxIndex = i;
                if (minIndex != -1 && maxIndex != -1) {
                    count += Math.min(minIndex, maxIndex) - previous;
                }
            }
        }

        return count;
    }
}
