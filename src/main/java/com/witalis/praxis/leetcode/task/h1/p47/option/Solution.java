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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return permuteUnique(numbers);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, used, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, boolean[] visit, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) continue;
            visit[i] = true;
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[i]);
            backtrack(nums, result, visit, tmp);
            visit[i] = false;
        }
    }
}
