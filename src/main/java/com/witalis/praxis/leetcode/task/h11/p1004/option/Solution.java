package com.witalis.praxis.leetcode.task.h11.p1004.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1004
 * Name: Max Consecutive Ones III
 * URL: <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Max Consecutive Ones III</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int flips;

    public Integer process() {
        return longestOnes(numbers, flips);
    }

    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }

        return j - i;
    }
}
