package com.witalis.praxis.leetcode.task.h25.p2401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2401
 * Name: Longest Nice Subarray
 * URL: <a href="https://leetcode.com/problems/longest-nice-subarray/">Longest Nice Subarray</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return longestNiceSubarray(numbers);
    }

    public int longestNiceSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int num = 0;
        int ans = 0;

        while (j < nums.length) {
            while ((num & nums[j]) != 0)
                num ^= nums[i++];

            num |= nums[j];
            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }
}
