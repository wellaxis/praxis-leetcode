package com.witalis.praxis.leetcode.task.h1.p40.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 40
 * Name: Combination Sum II
 * URL: https://leetcode.com/problems/combination-sum-ii/
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
        return combinationSum2(candidates, target);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                Integer option = options.get(i);

                if (i > j && option.equals(options.get(i - 1))) {
                    continue;
                }

                combination.push(option);
                target -= option;

                recursiveCombination(target, options, combinations, combination, i + 1);

                target += option;
                combination.pop();
            }
        }
    }
}
