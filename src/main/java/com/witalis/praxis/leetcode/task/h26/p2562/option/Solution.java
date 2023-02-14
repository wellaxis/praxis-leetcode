package com.witalis.praxis.leetcode.task.h26.p2562.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2562
 * Name: Find the Array Concatenation Value
 * URL: <a href="https://leetcode.com/problems/find-the-array-concatenation-value/">Find the Array Concatenation Value</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Long process() {
        return findTheArrayConcVal(numbers);
    }

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            res += helper(nums[i++], nums[j--]);
        }
        if (i == j) res += nums[i];

        return res;
    }

    private int helper(int x, int y) {
        int res = x;
        int temp = y;
        while (temp > 0) {
            res *= 10;
            temp /= 10;
        }

        return res + y;
    }
}
