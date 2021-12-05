package com.witalis.praxis.leetcode.task.p46.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 46
 * Name: Permutations
 * URL: https://leetcode.com/problems/permutations/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return permute(numbers);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> permutations = new ArrayList<>();
        permutation(permutations, nums, 0);

        return permutations;
    }

    private void permutation(List<List<Integer>> permutations, int[] nums, int index) {
        if (index == nums.length - 1) {
            permutations.add(Arrays.stream(nums).boxed().toList());
        } else {
            for (int i = index; i < nums.length; i++) {
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
