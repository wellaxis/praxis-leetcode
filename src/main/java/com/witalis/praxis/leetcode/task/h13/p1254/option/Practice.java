package com.witalis.praxis.leetcode.task.h13.p1254.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 1254
 * Name: Number of Closed Islands
 * URL: <a href="https://leetcode.com/problems/number-of-closed-islands/">Number of Closed Islands</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return closedIsland(grid);
    }

    enum Direction {
        NORTH(0, -1),
        SOUTH(0, 1),
        WEST(-1, 0),
        EAST(1, 0);

        private final int horizontal;
        private final int vertical;

        Direction(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    public int closedIsland(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        if (rows < 3 || cols < 3) return 0;

        int islands = 0;
        for (int row = 1; row < rows - 1; row++)
            for (int col = 1; col < cols - 1; col++)
                if (grid[row][col] == 0 && isClosed(grid, row, col))
                    islands++;

        return islands;
    }

    private boolean isClosed(int[][] grid, int row, int col) {
        if (grid[row][col] == 1)
            return true;

        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1)
            return false;

        grid[row][col] = 1;

        boolean north = isClosed(grid, row + Direction.NORTH.vertical, col + Direction.NORTH.horizontal);
        boolean south = isClosed(grid, row + Direction.SOUTH.vertical, col + Direction.SOUTH.horizontal);
        boolean west = isClosed(grid, row + Direction.WEST.vertical, col + Direction.WEST.horizontal);
        boolean east = isClosed(grid, row + Direction.EAST.vertical, col + Direction.EAST.horizontal);

        return north && south && west && east;
    }
}
