package com.witalis.praxis.leetcode.task.h7.p674.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 674
 * Name: Longest Continuous Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-continuous-increasing-subsequence/">Longest Continuous Increasing Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return findLengthOfLCIS(numbers);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 0;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }

        return Math.max(maxLength, length);
    }
}
