package com.witalis.praxis.leetcode.task.h3.p216.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 216
 * Name: Combination Sum III
 * URL: <a href="https://leetcode.com/problems/combination-sum-iii/">Combination Sum III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int qty;
    private int sum;

    public List<List<Integer>> process() {
        return combinationSum3(qty, sum);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) return Collections.emptyList();

        List<Set<Integer>> combinations = new LinkedList<>();
        recursiveCombination(k, n, combinations, new HashSet<>());

        List<List<Integer>> ans = new LinkedList<>();
        combinations.forEach(set -> ans.add(new LinkedList<>(set)));

        return ans;
    }

    private void recursiveCombination(int k, int n, List<Set<Integer>> combinations, Set<Integer> combination) {
        if (combination.size() == k) {
            if (n == 0 && !combinations.contains(combination)) {
                combinations.add(new HashSet<>(combination));
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!combination.contains(i)) {
                if (i > n) break;

                combination.add(i);
                recursiveCombination(k, n - i, combinations, combination);
                combination.remove(i);
            }
        }
    }
}
