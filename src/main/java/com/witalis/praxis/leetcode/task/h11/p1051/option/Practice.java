package com.witalis.praxis.leetcode.task.h11.p1051.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1051
 * Name: Height Checker
 * URL: <a href="https://leetcode.com/problems/height-checker/">Height Checker</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] heights;

    public Integer process() {
        return heightChecker(heights);
    }

    public int heightChecker(int[] heights) {
        if (heights == null) return 0;

        int discrepancies = 0;

        final int n = heights.length;
        if (n == 0) return discrepancies;

        final int[] expected = heights.clone();
        Arrays.sort(expected);

        for (int i = 0; i < n; i++)
            if (heights[i] != expected[i])
                discrepancies++;

        return discrepancies;
    }
}
