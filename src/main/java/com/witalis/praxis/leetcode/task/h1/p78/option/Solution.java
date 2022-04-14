package com.witalis.praxis.leetcode.task.h1.p78.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 78
 * Name: Subsets
 * URL: <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return subsets(numbers);
    }

    // Lexicographic (Binary Sorted) Subsets - Donald E. Knuth
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') subset.add(nums[j]);
            }
            output.add(subset);
        }

        return output;
    }
}
