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
        int result = 0;

        // there are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        int prefixMod = 0;
        for (int num : nums) {
            // take modulo twice to avoid negative remainders
            prefixMod = (prefixMod + num % k + k) % k;
            // add the count of sub-arrays that have the same remainder as the current one to cancel out the remainders
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }
}