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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return shortestBridge(grid);
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        if (grid == null) return 0;

        final int n = grid.length;
        if (n == 0) return 0;

        // find the 1st island
        final int[] island = findIsland(grid);
        if (island.length == 0) return 0;

        final Set<Integer> seen = new HashSet<>();
        dfs(grid, island[0], island[1], seen);

        // connect the 2nd island
        final Queue<Integer> queue = new ArrayDeque<>(seen);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int item = queue.poll();
                int ix = item / n;
                int iy = item % n;

                for (final int[] direction : DIRECTIONS) {
                    int dx = ix + direction[0];
                    int dy = iy + direction[1];
                    int neighbor = dx * n + dy;

                    if (dx >= 0 && dx < n && dy >= 0 && dy < n && !seen.contains(neighbor)) {
                        if (grid[dx][dy] == 1) return level;

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
        final int n = grid.length;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1) {
                    return new int[] {x, y};
                }
            }
        }

        return new int[0];
    }

    private void dfs(int[][] grid, int x, int y, Set<Integer> seen) {
        final int n = grid.length;

        int item = x * n + y;

        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1 || seen.contains(item)) return;

        seen.add(item);
        for (final int[] direction : DIRECTIONS) {
            int dx = x + direction[0];
            int dy = y + direction[1];
            dfs(grid, dx, dy, seen);
        }
    }
}
