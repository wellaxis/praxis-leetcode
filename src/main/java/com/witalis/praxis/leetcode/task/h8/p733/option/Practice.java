package com.witalis.praxis.leetcode.task.h8.p733.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 733
 * Name: Flood Fill
 * URL: <a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] image;
    private int centerRow;
    private int centerCol;
    private int floodColor;

    public int[][] process() {
        return floodFill(image, centerRow, centerCol, floodColor);
    }

    public enum directions {
        UP(-1, 0),
        LEFT(0, -1),
        DOWN(1, 0),
        RIGHT(0, 1);

        private final int row;
        private final int col;

        directions(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0) return image;

        int rows = image.length;
        int cols = image[0].length;

        boolean[][] flooded = new boolean[rows][cols];
        int baseColor = image[sr][sc];
        Queue<int[]> pixels = new ArrayDeque<>();
        pixels.offer(new int[] {sr, sc});

        int row;
        int col;
        int floodRow;
        int floodCol;
        while (!pixels.isEmpty()) {
            int[] pixel = pixels.poll();
            row = pixel[0];
            col = pixel[1];

            if (flooded[row][col]) continue;

            for (directions direction : directions.values()) {
                floodRow = row + direction.row;
                floodCol = col + direction.col;
                if (floodRow >= 0 && floodRow < rows && floodCol >= 0 && floodCol < cols && image[floodRow][floodCol] == baseColor) {
                    pixels.offer(new int[] {floodRow, floodCol});
                }
            }

            image[row][col] = color;
            flooded[row][col] = true;
        }

        return image;
    }
}
