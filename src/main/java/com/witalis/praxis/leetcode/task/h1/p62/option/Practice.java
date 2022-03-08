package com.witalis.praxis.leetcode.task.h1.p62.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 62
 * Name: Unique Paths
 * URL: https://leetcode.com/problems/unique-paths/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int m;
    private int n;

    public Integer process() {
        return uniquePaths(m, n);
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[] data = new int[n];
        Arrays.fill(data, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                data[j] += data[j - 1];
            }
        }

        return data[n - 1];
    }
}
