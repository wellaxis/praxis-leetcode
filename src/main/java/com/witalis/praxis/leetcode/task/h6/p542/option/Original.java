package com.witalis.praxis.leetcode.task.h6.p542.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 542
 * Name: 01 Matrix
 * URL: <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public int[][] process() {
        return updateMatrix(matrix);
    }

    enum Directions {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int row;
        private final int col;

        Directions(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    record Point(int row, int col) {}

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) return mat;

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] matrix = new int[rows][cols];
        Queue<Point> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    matrix[row][col] = 0;
                    queue.offer(new Point(row, col));
                } else {
                    matrix[row][col] = -1;
                }
            }
        }

        int path = 0;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size-- > 0) {
                Point point = queue.poll();

                for (Directions direction : Directions.values()) {
                    int dRow = point.row() + direction.row;
                    int dCol = point.col() + direction.col;

                    if (dRow >= 0 && dRow < rows && dCol >= 0 && dCol < cols && matrix[dRow][dCol] == -1) {
                        matrix[dRow][dCol] = path;
                        queue.offer(new Point(dRow, dCol));
                    }
                }
            }
        }

        return matrix;
    }
}
