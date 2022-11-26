package com.witalis.praxis.leetcode.task.h8.p733.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 733
 * Name: Flood Fill
 * URL: <a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] image;
    private int centerRow;
    private int centerCol;
    private int floodColor;

    public int[][] process() {
        return floodFill(image, centerRow, centerCol, floodColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor = image[sr][sc];
        if (prevColor != color) fill(image, sr, sc, color, prevColor);

        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int prevColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != prevColor) return;

        image[sr][sc] = color;

        fill(image, sr - 1, sc, color, prevColor);
        fill(image, sr + 1, sc, color, prevColor);
        fill(image, sr, sc - 1, color, prevColor);
        fill(image, sr, sc + 1, color, prevColor);
    }
}
