package com.witalis.praxis.leetcode.task.h7.p697.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 697
 * Name: Degree of an Array
 * URL: <a href="https://leetcode.com/problems/degree-of-an-array/">Degree of an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findShortestSubArray(numbers);
    }

    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        for (int num : nums) degree = Math.max(degree, num);

        int[] count = new int[degree + 1];
        int[] first = new int[degree + 1];
        int[] last = new int[degree + 1];

        int max = 1;
        for (int idx = 0; idx < nums.length; idx++) {
            count[nums[idx]]++;
            max = Math.max(max, count[nums[idx]]);
            if (first[nums[idx]] == 0) {
                first[nums[idx]] = idx + 1;
            }
            last[nums[idx]] = idx + 1;
        }

        int result = Integer.MAX_VALUE;
        for (int idx = 0; idx < count.length; idx++) {
            if (count[idx] == max) {
                result = Math.min(result, last[idx] - first[idx] + 1);
            }
        }

        return result;
    }
}
