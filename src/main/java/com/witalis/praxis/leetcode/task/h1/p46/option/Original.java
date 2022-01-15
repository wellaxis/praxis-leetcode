package com.witalis.praxis.leetcode.task.h1.p46.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 46
 * Name: Permutations
 * URL: https://leetcode.com/problems/permutations/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return permute(numbers);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> permutations = new HashSet<>();
        permutation(
            permutations,
            new ArrayList<>(),
            new ArrayList<>(Arrays.stream(nums).boxed().toList())
        );
        return new ArrayList<>(permutations);
    }

    private void permutation(Set<List<Integer>> permutations, List<Integer> prefix, List<Integer> suffix) {
        if (suffix.size() == 1) {
            prefix.addAll(suffix);
            permutations.add(prefix);
        } else {
            for (int i = 0; i < suffix.size(); i++) {
                Integer number = suffix.get(i);

                List<Integer> nextPrefix = new ArrayList<>(prefix);
                nextPrefix.add(number);

                List<Integer> nextSuffix = new ArrayList<>(suffix);
                nextSuffix.remove(number);

                permutation(permutations, nextPrefix, nextSuffix);
            }
        }
    }
}
