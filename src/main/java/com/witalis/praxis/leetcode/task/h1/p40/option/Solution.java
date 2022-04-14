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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] candidates;
    private int target;

    public List<List<Integer>> process() {
        return combinationSum2(candidates, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // container to hold the final combinations
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate))
                counter.put(candidate, counter.get(candidate) + 1);
            else
                counter.put(candidate, 1);
        }

        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach(
            (key, value) -> counterList.add(new int[]{key, value})
        );

        backtrack(comb, target, 0, counterList, results);
        return results;
    }

    private void backtrack(LinkedList<Integer> comb, int remain, int curr, List<int[]> counter, List<List<Integer>> results) {
        if (remain <= 0) {
            if (remain == 0) {
                // make a deep copy of the current combination.
                results.add(new ArrayList<>(comb));
            }
            return;
        }

        for (int nextCurr = curr; nextCurr < counter.size(); ++nextCurr) {
            int[] entry = counter.get(nextCurr);
            int candidate = entry[0];
            int frequency = entry[1];

            if (frequency <= 0) continue;

            if (remain - candidate >= 0) {
                // add a new element to the current combination
                comb.addLast(candidate);
                counter.set(nextCurr, new int[]{candidate, frequency - 1});

                // continue the exploration with the updated combination
                backtrack(comb, remain - candidate, nextCurr, counter, results);

                // backtrack the changes, so that we can try another candidate
                counter.set(nextCurr, new int[]{candidate, frequency});
                comb.removeLast();
            }
        }
    }
}
