package com.witalis.praxis.leetcode.task.h25.p2401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2401
 * Name: Longest Nice Subarray
 * URL: <a href="https://leetcode.com/problems/longest-nice-subarray/">Longest Nice Subarray</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return longestNiceSubarray(numbers);
    }

    public int longestNiceSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLen = 1;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curLen = 1;
            int current = nums[i];
            for (int j = i; j < len - 1; j++) {
                if ((current ^ nums[j + 1]) == current + nums[j + 1]) {
                    current += nums[j + 1];
                    curLen++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}
