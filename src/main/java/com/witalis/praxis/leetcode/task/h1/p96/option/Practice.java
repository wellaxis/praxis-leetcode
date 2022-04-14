package com.witalis.praxis.leetcode.task.h1.p96.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 96
 * Name: Unique Binary Search Trees
 * URL: <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique Binary Search Trees</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return numTrees(number);
    }

    public int numTrees(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;

        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        int min;
        int max;
        for (int i = 2; i < f.length; i++) {
            min = -1;
            max = i;
            while (++min <= --max) {
                f[i] += (f[max] * f[min]) * ((min == max) ? 1 : 2);
            }
        }

        return f[n];
    }
}