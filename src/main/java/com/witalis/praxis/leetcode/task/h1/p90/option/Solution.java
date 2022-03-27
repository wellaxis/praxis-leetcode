package com.witalis.praxis.leetcode.task.h1.p90.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 90
 * Name: Subsets II
 * URL: https://leetcode.com/problems/subsets-ii/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return subsetsWithDup(numbers);
    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();

        if (num == null || num.length == 0) return result;

        Arrays.sort(num);

        dfs(result, new ArrayList<>(), num, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            dfs(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
