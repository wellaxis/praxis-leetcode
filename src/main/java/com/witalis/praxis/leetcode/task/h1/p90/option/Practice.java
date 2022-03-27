package com.witalis.praxis.leetcode.task.h1.p90.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 90
 * Name: Subsets II
 * URL: https://leetcode.com/problems/subsets-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return subsetsWithDup(numbers);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        Set<List<Integer>> subsets = new HashSet<>(List.of(Collections.emptyList()));
        recursiveSubset(subsets, new ArrayList<>(), nums, 0);

        return new ArrayList<>(subsets);
    }

    private void recursiveSubset(Set<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            Integer number = nums[i];
            subset.add(number);

            subsets.add(new ArrayList<>(subset));
            recursiveSubset(subsets, subset, nums, i + 1);

            subset.remove(number);
        }
    }
}
