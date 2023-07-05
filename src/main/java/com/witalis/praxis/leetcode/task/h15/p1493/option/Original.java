package com.witalis.praxis.leetcode.task.h15.p1493.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1493
 * Name: Longest Subarray of 1's After Deleting One Element
 * URL: <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">Longest Subarray of 1's After Deleting One Element</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        int i = 0;
        while (i < n && nums[i] == 0) i++;

        if (i == n) return 0;

        int zeroes = i > 0 ? 0 : 1;
        while (i < n) {
            if (nums[i] == 1) {
                fullLength++;
                if (halfLength >= 0) halfLength++;
            } else {
                if (i + 1 < n && nums[i + 1] == 1) {
                    if (halfLength < 0) {
                        halfLength++;
                    } else {
                        maxLength = Math.max(maxLength, fullLength);
                        fullLength = halfLength;
                        halfLength = 0;
                    }
                } else {
                    maxLength = Math.max(maxLength, fullLength);
                    fullLength = 0;
                    halfLength = -1;
                }
                zeroes = 0;
            }
            i++;
        }

        return Math.max(maxLength, fullLength) - zeroes;
    }
}
