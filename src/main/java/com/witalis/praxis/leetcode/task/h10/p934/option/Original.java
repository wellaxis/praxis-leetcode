package com.witalis.praxis.leetcode.task.h10.p934.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * ID: 934
 * Name: Shortest Bridge
 * URL: <a href="https://leetcode.com/problems/shortest-bridge/">Shortest Bridge</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Original(int[][] grid) {
        this.grid = grid;
    }

    public Integer process() {
        return shortestBridge(grid);
    }

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;

        // find the 1st island
        int[] island = findIsland(grid);
        if (island.length == 0) return 0;

        Set<Integer> seen = new HashSet<>();
        dfs(grid, island[0], island[1], seen);

        // connect the 2nd island
        Queue<Integer> queue = new ArrayDeque<>(seen);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int item = queue.poll();
                int ix = item / n;
                int iy = item % n;

                for (int[] direction : directions) {
                    int dx = ix + direction[0];
                    int dy = iy + direction[1];
                    int neighbor = dx * n + dy;

                    if (dx >= 0 && dx < n && dy >= 0 && dy < n && !seen.contains(neighbor)) {
                        if (grid[dx][dy] == 1) {
                            return level;
                        }
                        queue.offer(neighbor);
                        seen.add(neighbor);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private int[] findIsland(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[0];
    }

    private void dfs(int[][] grid, int x, int y, Set<Integer> seen) {
        int n = grid.length;
        int item = x * n + y;

        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1 || seen.contains(item)) return;

        seen.add(item);
        for (int[] direction : directions) {
            int dx = x + direction[0];
            int dy = y + direction[1];
            dfs(grid, dx, dy, seen);
        }
    }
}
