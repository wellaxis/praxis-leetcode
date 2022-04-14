package com.witalis.praxis.leetcode.task.h1.p77.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 77
 * Name: Combinations
 * URL: <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int n;
    private int k;

    public List<List<Integer>> process() {
        return combine(n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || n < k) return result;

        dfs(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> result) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }
}
