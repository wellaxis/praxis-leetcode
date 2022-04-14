package com.witalis.praxis.leetcode.task.h1.p47.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 47
 * Name: Permutations II
 * URL: <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return permuteUnique(numbers);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        Set<List<Integer>> permutations = new HashSet<>();
        permutation(permutations, nums, 0);

        return new ArrayList<>(permutations);
    }

    private void permutation(Set<List<Integer>> permutations, int[] nums, int index) {
        if (index == nums.length - 1) {
            permutations.add(Arrays.stream(nums).boxed().toList());
        } else {
            Set<Integer> processed = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (processed.contains(nums[i])) continue;
                processed.add(nums[i]);

                if (i != index) swap(nums, index, i);
                permutation(permutations, nums, index + 1);
                if (i != index) swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
