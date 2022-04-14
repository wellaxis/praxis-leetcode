package com.witalis.praxis.leetcode.task.h3.p268.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 268
 * Name: Missing Number
 * URL: <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return missingNumber(numbers);
    }

    public int missingNumber(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length; i ++) {
            miss = miss ^ (i + 1);
            miss = miss ^ nums[i];
        }

        return miss;
    }
}
