package com.witalis.praxis.leetcode.task.h5.p491.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 491
 * Name: Non-decreasing Subsequences
 * URL: <a href="https://leetcode.com/problems/non-decreasing-subsequences/">Non-decreasing Subsequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return findSubsequences(numbers);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int bitmask = 1; bitmask < (1 << n); bitmask++) {
            List<Integer> sequence = new ArrayList<>();
            // check the i-th bit of the bitmask
            for (int i = 0; i < n; i++) {
                if (((bitmask >> i) & 1) == 1) {
                    sequence.add(nums[i]);
                }
            }
            if (sequence.size() >= 2) {
                // check whether the sequence is increasing
                boolean isIncreasing = true;
                for (int i = 0; i < sequence.size() - 1; i++) {
                    isIncreasing &= sequence.get(i) <= sequence.get(i + 1);
                }
                if (isIncreasing) {
                    result.add(sequence);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
