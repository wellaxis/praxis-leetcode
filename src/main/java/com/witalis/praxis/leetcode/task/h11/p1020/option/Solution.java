package com.witalis.praxis.leetcode.task.h11.p1020.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 1020
 * Name: Number of Enclaves
 * URL: <a href="https://leetcode.com/problems/number-of-enclaves/">Number of Enclaves</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Integer process() {
        return numEnclaves(grid);
    }

    public static final int[][] NEIGHBORS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // first row
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1) bfs(grid, 0, i);
        }
        // last column
        for (int i = 1; i < rows; i++) {
            if (grid[i][cols - 1] == 1) bfs(grid, i, cols - 1);
        }
        // last row
        for (int i = cols - 2; i >= 0; i--) {
            if (grid[rows - 1][i] == 1) bfs(grid, rows - 1, i);
        }
        // first column
        for (int i = rows - 2; i >= 1; i--) {
            if (grid[i][0] == 1) bfs(grid, i, 0);
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count += grid[i][j];
            }
        }

        return count;
    }

    private void bfs(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] neighbor : NEIGHBORS) {
                if (isValid(curr[0] + neighbor[0], curr[1] + neighbor[1], grid.length, grid[0].length) &&
                    grid[curr[0] + neighbor[0]][curr[1] + neighbor[1]] == 1) {
                    // mark as visited
                    grid[curr[0] + neighbor[0]][curr[1] + neighbor[1]] = 0;
                    q.add(new int[]{curr[0] + neighbor[0], curr[1] + neighbor[1]});
                }
            }
        }
    }

    private static boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
