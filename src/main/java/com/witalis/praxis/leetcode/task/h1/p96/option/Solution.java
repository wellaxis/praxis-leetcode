package com.witalis.praxis.leetcode.task.h1.p96.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 96
 * Name: Unique Binary Search Trees
 * URL: <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique Binary Search Trees</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return numTrees(number);
    }

    public int numTrees(int n) {
        if (n <= 1) return 1;

        int[] c = new int[n + 1];
        c[0] = c[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                c[i] += c[j] * c[i - j - 1];
            }
        }

        return c[n];
    }
}
