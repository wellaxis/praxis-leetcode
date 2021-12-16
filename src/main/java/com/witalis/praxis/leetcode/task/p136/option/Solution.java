package com.witalis.praxis.leetcode.task.p136.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 136
 * Name: Single Number
 * URL: https://leetcode.com/problems/single-number/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return singleNumber(numbers);
    }

    public int singleNumber(int[] nums) {
        // xor (exclusive or): a^a = 0, a^b^a = b.

        int a = 0;
        for (int num : nums) a ^= num;
        return a;
    }
}
