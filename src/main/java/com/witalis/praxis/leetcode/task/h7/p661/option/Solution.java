package com.witalis.praxis.leetcode.task.h7.p661.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 661
 * Name: Image Smoother
 * URL: <a href="https://leetcode.com/problems/image-smoother/">Image Smoother</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] image;

    public int[][] process() {
        return imageSmoother(image);
    }

    public int[][] imageSmoother(int[][] img) {
        final int m = img.length;
        final int n = img[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int ones = 0;
                int count = 0;
                for (int y = Math.max(0, i - 1); y < Math.min(m, i + 2); ++y)
                    for (int x = Math.max(0, j - 1); x < Math.min(n, j + 2); ++x) {
                        ones += img[y][x];
                        ++count;
                    }
                ans[i][j] = ones / count;
            }

        return ans;
    }
}
