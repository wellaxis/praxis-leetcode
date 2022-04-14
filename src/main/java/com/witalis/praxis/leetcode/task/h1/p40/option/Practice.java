package com.witalis.praxis.leetcode.task.h1.p40.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 40
 * Name: Combination Sum II
 * URL: <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
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
        return combinationSum2(candidates, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i < index && candidate == candidates[i + 1]) continue;

                // store option
                combination.offerLast(candidate);

                recursiveCombination(candidates, target - candidate, combinations, combination, i - 1);

                // restore option
                combination.pollLast();
            }
        }
        return combinations;
    }
}
