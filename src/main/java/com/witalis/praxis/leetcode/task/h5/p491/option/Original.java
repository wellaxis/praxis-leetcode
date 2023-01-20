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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return findSubsequences(numbers);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> subsequences = new HashSet<>();
        recursiveTraverse(nums, subsequences, new ArrayList<>(), 0);

        return new ArrayList<>(subsequences);
    }

    private void recursiveTraverse(int[] nums, Set<List<Integer>> subsequences, List<Integer> subsequence, int index) {
        if (index >= nums.length) return;

        int previous = subsequence.isEmpty() ? Integer.MIN_VALUE : subsequence.get(subsequence.size() - 1);
        int current = nums[index];
        if (previous <= current) {
            subsequence.add(current);

            if (subsequence.size() > 1) {
                subsequences.add(new ArrayList<>(subsequence));
            }

            for (int i = index + 1; i < nums.length; i++) {
                recursiveTraverse(nums, subsequences, subsequence, i);
                recursiveTraverse(nums, subsequences, new ArrayList<>(), i);
            }

            subsequence.remove(subsequence.size() - 1);
        }
    }
}
