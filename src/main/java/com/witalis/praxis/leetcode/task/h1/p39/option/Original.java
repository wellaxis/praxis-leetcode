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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] candidates;
    private int target;

    public List<List<Integer>> process() {
        return combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();

        List<Integer> options = Arrays.stream(candidates)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .toList();

        Set<List<Integer>> combinations = new HashSet<>();
        recursiveCombination(target, options, combinations, new Stack<>(), 0);
        return new ArrayList<>(combinations);
    }

    private void recursiveCombination(int target, List<Integer> options, Set<List<Integer>> combinations, Stack<Integer> combination, int j) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            combinations.add(new ArrayList<>(combination));
        } else {
            for (int i = j; i < options.size(); i++) {
                int option = options.get(i);

                combination.push(option);
                target -= option;

                recursiveCombination(target, options, combinations, combination, i);

                target += option;
                combination.pop();
            }
        }
    }
}
