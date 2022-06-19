package com.witalis.praxis.leetcode.task.h1.p85.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 85
 * Name: Maximal Rectangle
 * URL: <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] matrix;

    public Integer process() {
        return maximalRectangle(matrix);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix[0] == null) return 0;

        int maxArea = 0;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        int[][] data = new int[rows][cols];

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (row == 0) {
                    data[row][col] = matrix[row][col] == '0' ? 0 : 1;
                } else {
                    data[row][col] = matrix[row][col] == '0' ? 0: data[row - 1][col] + 1;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            int area = largestRectangleArea(data[row]);
            if (area > maxArea) maxArea = area;
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Deque<Integer> candidates = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!candidates.isEmpty() && h < heights[candidates.peek()]) {
                int height = heights[candidates.pop()];
                int index = candidates.isEmpty() ? -1 : candidates.peek();
                maxArea = Math.max(maxArea, height * (i - index - 1));
            }

            candidates.push(i);
        }

        return maxArea;
    }
}
