package com.witalis.praxis.leetcode.task.h1.p77.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 77
 * Name: Combinations
 * URL: <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int n;
    private int k;

    public List<List<Integer>> process() {
        return combine(n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) return Collections.emptyList();

        List<List<Integer>> combinations = new ArrayList<>();
        recursiveCombine(combinations, new ArrayList<>(), n, k, 1);

        return combinations;
    }

    private void recursiveCombine(
        List<List<Integer>> combinations,
        List<Integer> combination,
        int n,
        int k,
        int index
    ) {
        for (int i = index; i <= n - k + 1; i++) {
            List<Integer> subCombination = new ArrayList<>(combination);
            subCombination.add(i);
            if (k == 1) {
                combinations.add(subCombination);
            } else {
                recursiveCombine(combinations, subCombination, n, k - 1, i + 1);
            }
        }
    }
}
