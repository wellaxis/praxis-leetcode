package com.witalis.praxis.leetcode.task.h1.p85.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 85
 * Name: Maximal Rectangle
 * URL: <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] matrix;

    public Solution(char[][] matrix) {
        this.matrix = matrix;
    }

    public Integer process() {
        return maximalRectangle(matrix);
    }

    private int rows;
    private int cols;
    private int[] left;
    private int[] right;
    private int[] height;

    public int maximalRectangle(char[][] matrix) {
        this.matrix = matrix;

        rows = matrix.length;
        cols = matrix[0].length;
        left = new int[cols];
        right = new int[cols];
        height = new int[cols];
        Arrays.fill(right, cols);

        int max = 0;
        for (int i = 0; i < rows; i++)
            max = Math.max(max, dp(i));

        return max;
    }

    private int dp(int row) {
        int currentLeft = 0;
        int currentRight = cols;

        // update height cache
        for (int i = 0; i < cols; i++) {
            if (matrix[row][i] == '1')
                height[i]++;
            else
                height[i] = 0;
        }

        // update left cache
        for (int i = 0; i < cols; i++) {
            if (matrix[row][i] == '1')
                left[i] = Math.max(left[i], currentLeft);
            else {
                left[i] = 0;
                currentLeft = i + 1;
            }
        }

        // update right cache
        for (int i = cols - 1; i >= 0; i--) {
            if (matrix[row][i] == '1')
                right[i] = Math.min(right[i], currentRight);
            else {
                right[i] = cols;
                currentRight = i;
            }
        }

        // update area
        int max = 0;
        for (int i = 0; i < cols; i++)
            max = Math.max(max, (right[i] - left[i]) * height[i]);

        return max;
    }
}
