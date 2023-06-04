package com.witalis.praxis.leetcode.task.h6.p547.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 547
 * Name: Number of Provinces
 * URL: <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] isConnected;

    public Practice(int[][] isConnected) {
        this.isConnected = isConnected;
    }

    public Integer process() {
        return findCircleNum(isConnected);
    }

    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null) return 0;

        final int n = isConnected.length;
        this.seen = new boolean[n];

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                provinces++;
                dfs(isConnected, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int city) {
        seen[city] = true;

        for (int i = 0; i < isConnected.length; i++) {
            final int connection = isConnected[city][i];
            if (connection == 1 && !seen[i])
                dfs(isConnected, i);
        }
    }
}
