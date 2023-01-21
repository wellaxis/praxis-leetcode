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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return findSubsequences(numbers);
    }

    private final Set<List<Integer>> subsequences = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        recursiveTraverse(nums, new ArrayList<>(), 0);

        return new ArrayList<>(subsequences);
    }

    private void recursiveTraverse(int[] nums, List<Integer> subsequence, int index) {
        if (index == nums.length) {
            if (subsequence.size() > 1) {
                subsequences.add(new ArrayList<>(subsequence));
            }
            return;
        }

        int previous = subsequence.isEmpty() ? Integer.MIN_VALUE : subsequence.get(subsequence.size() - 1);
        int current = nums[index];
        if (previous <= current) {
            subsequence.add(current);
            recursiveTraverse(nums, subsequence, index + 1);
            subsequence.remove(subsequence.size() - 1);
        }
        recursiveTraverse(nums, subsequence, index + 1);
    }
}
