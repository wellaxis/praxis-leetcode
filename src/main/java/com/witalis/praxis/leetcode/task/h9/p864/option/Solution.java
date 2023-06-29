package com.witalis.praxis.leetcode.task.h9.p864.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 864
 * Name: Shortest Path to Get All Keys
 * URL: <a href="https://leetcode.com/problems/shortest-path-to-get-all-keys/">Shortest Path to Get All Keys</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] grid;

    public Integer process() {
        return shortestPathAllKeys(grid);
    }

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int keycount = 0;
        int[] start = {-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = grid[i].charAt(j);
                if (cur >= 'a' && cur <= 'z') keycount++;
                else if (cur == '@') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        boolean[][][] visited = new boolean[n][m][(1 << keycount)];
        visited[start[0]][start[1]][0] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 0});

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.pop();
                if (cur[2] == (1 << keycount) - 1) return step;

                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dirs[j][0];
                    int newY = cur[1] + dirs[j][1];
                    int newHas = cur[2];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX].charAt(newY) == '#') continue;
                    char currPosition = grid[newX].charAt(newY);
                    if (currPosition >= 'A' && currPosition <= 'Z') {
                        if (((newHas & (1 << (currPosition - 'A'))) == 0) || visited[newX][newY][newHas]) continue;
                        visited[newX][newY][newHas] = true;
                        q.add(new int[]{newX, newY, newHas});
                    } else {
                        if (currPosition >= 'a' && currPosition <= 'z') newHas = newHas | (1 << (currPosition - 'a'));
                        if (visited[newX][newY][newHas]) continue;
                        visited[newX][newY][newHas] = true;
                        q.add(new int[]{newX, newY, newHas});
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
