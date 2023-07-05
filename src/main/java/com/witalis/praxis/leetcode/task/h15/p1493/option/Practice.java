package com.witalis.praxis.leetcode.task.h15.p1493.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1493
 * Name: Longest Subarray of 1's After Deleting One Element
 * URL: <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">Longest Subarray of 1's After Deleting One Element</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return longestSubarray(numbers);
    }

    public int longestSubarray(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        int maxLength = 0;
        int fullLength = 0;
        int halfLength = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                fullLength++;
                if (halfLength >= 0) halfLength++;
            } else {
                if (fullLength > 0 && i + 1 < n && nums[i + 1] == 1) {
                    if (halfLength < 0) {
                        halfLength++;
                    } else {
                        if (fullLength > maxLength) maxLength = fullLength;
                        fullLength = halfLength;
                        halfLength = 0;
                    }
                } else {
                    if (fullLength > maxLength) maxLength = fullLength;
                    fullLength = 0;
                    halfLength = -1;
                }
            }
        }

        if (fullLength == n) return n - 1;

        return Math.max(maxLength, fullLength);
    }
}
