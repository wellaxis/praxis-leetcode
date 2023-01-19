package com.witalis.praxis.leetcode.task.h10.p974.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 974
 * Name: Subarray Sums Divisible by K
 * URL: <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int denominator;

    public Integer process() {
        return subarraysDivByK(numbers, denominator);
    }

    public int subarraysDivByK(int[] nums, int k) {
        return 0;
    }
}