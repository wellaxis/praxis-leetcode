package com.witalis.praxis.leetcode.task.h1.p96.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 96
 * Name: Unique Binary Search Trees
 * URL: https://leetcode.com/problems/unique-binary-search-trees/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
            min = 0;
            max = i - 1;
            while (min <= max) {
                if (min == max) {
                    f[i] += f[max] * f[min];
                } else {
                    f[i] += 2 * (f[max] * f[min]);
                }
                max--;
                min++;
            }
        }

        return f[n];
    }
}
