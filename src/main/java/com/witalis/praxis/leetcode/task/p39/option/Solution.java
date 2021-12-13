package com.witalis.praxis.leetcode.task.p39.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 39
 * Name: Combination Sum
 * URL: https://leetcode.com/problems/combination-sum/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] candidates;
    private int target;

    public List<List<Integer>> process() {
        return combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        toFindCombinationsToTarget(results, combination, candidates, target, 0);

        return results;
    }

    private void toFindCombinationsToTarget(List<List<Integer>> results, List<Integer> combination, int[] candidates, int target, int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            toFindCombinationsToTarget(results, combination, candidates, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
