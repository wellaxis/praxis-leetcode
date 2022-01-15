package com.witalis.praxis.leetcode.task.h1.p39.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 39
 * Name: Combination Sum
 * URL: https://leetcode.com/problems/combination-sum/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] candidates;
    private int target;

    public List<List<Integer>> process() {
        return combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();

        // sort candidates
        Arrays.sort(candidates);

        return recursiveCombination(candidates, target, new ArrayList<>(), new ArrayDeque<>(), candidates.length - 1);
    }

    private List<List<Integer>> recursiveCombination(int[] candidates, int target, List<List<Integer>> combinations, Deque<Integer> combination, int index) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
        } else {
            // loop from the biggest to the smallest one
            for (int i = index; i >= 0; i--) {
                int candidate = candidates[i];

                if (target < candidate) continue;

                // store option
                combination.offerLast(candidate);

                recursiveCombination(candidates, target - candidate, combinations, combination, i);

                // restore option
                combination.pollLast();
            }
        }
        return combinations;
    }
}
