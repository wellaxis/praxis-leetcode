package com.witalis.praxis.leetcode.task.h1.p47.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 47
 * Name: Permutations II
 * URL: <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return permuteUnique(numbers);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        Set<List<Integer>> permutations = new HashSet<>();
        permutation(
            permutations,
            new ArrayList<>(),
            new ArrayList<>(Arrays.stream(nums).boxed().toList())
        );
        return new ArrayList<>(permutations);
    }

    private void permutation(Set<List<Integer>> permutations, List<Integer> prefix, List<Integer> suffix) {
        if (suffix.isEmpty()) {
            permutations.add(prefix);
        } else {
            Integer previous = null;
            for (Integer number: suffix) {
                if (previous != null && number.intValue() == previous.intValue()) continue;

                List<Integer> nextPrefix = new ArrayList<>(prefix);
                nextPrefix.add(number);

                List<Integer> nextSuffix = new ArrayList<>(suffix);
                nextSuffix.remove(number);

                permutation(permutations, nextPrefix, nextSuffix);

                previous = number;
            }
        }
    }
}
