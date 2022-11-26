package com.witalis.praxis.leetcode.task.h8.p733.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * ID: 733
 * Name: Flood Fill
 * URL: <a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] image;
    private int centerRow;
    private int centerCol;
    private int floodColor;

    public int[][] process() {
        return floodFill(image, centerRow, centerCol, floodColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0) return image;

        int rows = image.length;
        int cols = image[0].length;

        boolean[][] flooded = new boolean[rows][cols];
        int baseColor = image[sr][sc];
        Queue<int[]> pixels = new ArrayDeque<>();
        pixels.offer(new int[] {sr, sc});
        while (!pixels.isEmpty()) {
            int[] pixel = pixels.poll();
            int row = pixel[0];
            int col = pixel[1];

            if (flooded[row][col]) continue;

            if (row - 1 >= 0 && image[row - 1][col] == baseColor) pixels.offer(new int[] {row - 1, col});
            if (col - 1 >= 0 && image[row][col - 1] == baseColor) pixels.offer(new int[] {row, col - 1});
            if (row + 1 < rows && image[row + 1][col] == baseColor) pixels.offer(new int[] {row + 1, col});
            if (col + 1 < cols && image[row][col + 1] == baseColor) pixels.offer(new int[] {row, col + 1});

            image[row][col] = color;
            flooded[row][col] = true;
        }

        return image;
    }
}
