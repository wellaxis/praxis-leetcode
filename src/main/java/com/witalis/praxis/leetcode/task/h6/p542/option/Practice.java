package com.witalis.praxis.leetcode.task.h6.p542.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 542
 * Name: 01 Matrix
 * URL: <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public int[][] process() {
        return updateMatrix(matrix);
    }

    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) return mat;

        final int rows = mat.length;
        final int cols = mat[0].length;

        final Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (mat[row][col] == 0)
                    queue.offer(new int[] {row, col});
                else
                    mat[row][col] = -1;

        int path = 0;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size-- > 0) {
                int[] point = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int dRow = point[0] + direction[0];
                    int dCol = point[1] + direction[1];

                    if (dRow >= 0 && dRow < rows && dCol >= 0 && dCol < cols && mat[dRow][dCol] == -1) {
                        mat[dRow][dCol] = path;
                        queue.offer(new int[] {dRow, dCol});
                    }
                }
            }
        }

        return mat;
    }
}
