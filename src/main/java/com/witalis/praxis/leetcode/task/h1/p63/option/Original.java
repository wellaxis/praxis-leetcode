package com.witalis.praxis.leetcode.task.h1.p63.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 63
 * Name: Unique Paths II
 * URL: https://leetcode.com/problems/unique-paths-ii/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] obstacleGrid;

    public Integer process() {
        return uniquePathsWithObstacles(obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1 && n == 1) return Math.abs(obstacleGrid[0][0] - 1);
        if (n == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                while (i < m) obstacleGrid[i++][0] = 0;
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                obstacleGrid[0][j] = 1;
            } else {
                while (j < n) obstacleGrid[0][j++] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
