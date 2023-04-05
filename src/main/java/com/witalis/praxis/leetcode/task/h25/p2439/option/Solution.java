package com.witalis.praxis.leetcode.task.h25.p2439.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2439
 * Name: Minimize Maximum of Array
 * URL: <a href="https://leetcode.com/problems/minimize-maximum-of-array/">Minimize Maximum of Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minimizeArrayValue(numbers);
    }

    public int minimizeArrayValue(int[] nums) {
        long answer = 0;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int) answer;
    }
}
