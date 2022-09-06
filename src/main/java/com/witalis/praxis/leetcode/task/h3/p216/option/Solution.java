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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int qty;
    private int sum;

    public List<List<Integer>> process() {
        return combinationSum3(qty, sum);

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (k > 9 || n > 45) return result;

        dfs(result, k, n, new LinkedList<>(), 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, int k, int n, List<Integer> curr, int start) {
        if (k == 0) {
            if (n == 0) {
                result.add(new LinkedList<>(curr));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if ((9 - i) < k - 1) return;

            curr.add(i);
            dfs(result, k - 1, n - i, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
