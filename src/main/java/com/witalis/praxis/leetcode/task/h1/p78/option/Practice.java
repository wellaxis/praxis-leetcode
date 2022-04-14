package com.witalis.praxis.leetcode.task.h1.p78.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 78
 * Name: Subsets
 * URL: <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return subsets(numbers);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> subsets = new ArrayList<>(List.of(Collections.emptyList()));
        recursiveSubset(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private void recursiveSubset(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            Integer number = nums[i];
            subset.add(number);

            subsets.add(new ArrayList<>(subset));
            recursiveSubset(subsets, subset, nums, i + 1);

            subset.remove(number);
        }
    }
}
