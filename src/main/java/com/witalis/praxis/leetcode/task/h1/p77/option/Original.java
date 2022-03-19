package com.witalis.praxis.leetcode.task.h1.p77.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 77
 * Name: Combinations
 * URL: https://leetcode.com/problems/combinations/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int n;
    private int k;

    public List<List<Integer>> process() {
        return combine(n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) return Collections.emptyList();

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().toList();
        recursiveCombine(combinations, k, new ArrayList<>(), new ArrayList<>(numbers));
        return combinations;
    }

    private void recursiveCombine(
        List<List<Integer>> combinations,
        int k,
        List<Integer> combination,
        List<Integer> numbers
    ) {
        if (combination.size() == k) {
            combinations.add(combination);
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                Integer number = numbers.get(i);
                if (!combination.isEmpty() && number < combination.get(combination.size() - 1)) continue;

                List<Integer> subCombination = new ArrayList<>(combination);
                subCombination.add(number);

                List<Integer> subNumbers = new ArrayList<>(numbers);
                subNumbers.remove(number);

                recursiveCombine(combinations, k, subCombination, subNumbers);
            }
        }
    }
}
