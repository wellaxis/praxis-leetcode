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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int qty;
    private int sum;

    public Practice(int qty, int sum) {
        this.qty = qty;
        this.sum = sum;
    }

    public List<List<Integer>> process() {
        return combinationSum3(qty, sum);
    }

    private List<List<Integer>> combinations = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) return Collections.emptyList();

        recursiveCombination(k, n, 1, new LinkedList<>());

        return combinations;
    }

    private void recursiveCombination(int k, int n, int l, List<Integer> combination) {
        if (combination.size() == k) {
            if (n == 0) {
                combinations.add(new LinkedList<>(combination));
            }
            return;
        }

        for (int i = l; i <= 9; i++) {
            if (i > n) break;

            combination.add(i);
            recursiveCombination(k, n - i, i + 1, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
