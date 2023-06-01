package com.witalis.praxis.leetcode.task.h11.p1091.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * ID: 1091
 * Name: Shortest Path in Binary Matrix
 * URL: <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/description/">Shortest Path in Binary Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return shortestPathBinaryMatrix(grid);
    }

    public enum Direction {
        NORTH(-1, 0),
        NORTH_EAST(-1, 1),
        EAST(0, 1),
        SOUTH_EAST(1, 1),
        SOUTH(1, 0),
        SOUTH_WEST(1, -1),
        WEST(0, -1),
        NORTH_WEST(-1, -1);

        final int row;
        final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public record Position(int row, int col, int steps) {}

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null) return -1;

        final int n = grid.length;

        if (n == 0) return -1;
        if (grid[0][0] != 0) return -1;
        if (grid[n - 1][n - 1] != 0) return -1;

        final boolean[][] seen = new boolean[n][n];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                seen[row][col] = grid[row][col] == 1;

        final Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(0, 0, 1));
        seen[0][0] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            if (position.row == n - 1 && position.col == n - 1) return position.steps;

            Arrays.stream(Direction.values()).forEach(
                direction -> {
                    int row = position.row + direction.row;
                    int col = position.col + direction.col;

                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && !seen[row][col]) {
                        seen[row][col] = true;
                        queue.offer(new Position(row, col, position.steps + 1));
                    }
                }
            );
        }

        return -1;
    }
}
