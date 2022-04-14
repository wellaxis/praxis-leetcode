package com.witalis.praxis.leetcode.task.h1.p78.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 78
 * Name: Subsets
 * URL: <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return subsets(numbers);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> subsets = new HashSet<>();
        recursiveSubset(
            subsets,
            new ArrayList<>(),
            new ArrayList<>(Arrays.stream(nums).boxed().toList())
        );
        return new ArrayList<>(subsets);
    }

    private void recursiveSubset(Set<List<Integer>> subsets, List<Integer> subset, List<Integer> numbers) {
        List<Integer> combination = new ArrayList<>(subset);
        combination.sort(Integer::compareTo);
        if (subsets.contains(combination)) {
            return;
        } else {
            subsets.add(combination);
        }

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (!subset.isEmpty() && number < subset.get(subset.size() - 1)) continue;

            List<Integer> subSet = new ArrayList<>(subset);
            subSet.add(number);

            List<Integer> subNumbers = new ArrayList<>(numbers);
            subNumbers.remove(number);

            recursiveSubset(subsets, subSet, subNumbers);
        }
    }
}
