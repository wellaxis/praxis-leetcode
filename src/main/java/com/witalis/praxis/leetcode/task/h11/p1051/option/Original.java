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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] heights;

    public Integer process() {
        return heightChecker(heights);
    }

    static class Pair {
        private final int current;
        private int expected;

        public Pair(int current) {
            this.current = current;
        }
    }

    public int heightChecker(int[] heights) {
        if (heights == null) return 0;

        int n = heights.length;
        if (n == 0) return 0;

        final Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) pairs[i] = new Pair(heights[i]);

        Arrays.sort(heights);

        for (int i = 0; i < n; i++) pairs[i].expected = heights[i];

        return (int) Arrays.stream(pairs).filter(p -> p.current != p.expected).count();
    }
}
