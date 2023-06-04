package com.witalis.praxis.leetcode.task.h6.p547.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 547
 * Name: Number of Provinces
 * URL: <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] isConnected;

    public Original(int[][] isConnected) {
        this.isConnected = isConnected;
    }

    public Integer process() {
        return findCircleNum(isConnected);
    }

    private Map<Integer, List<Integer>> connections;
    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null) return 0;

        final int n = isConnected.length;
        this.connections = new HashMap<>();
        for (int i = 0; i < n; i++) {
            connections.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++)
                if (isConnected[i][j] == 1)
                    connections.get(i).add(j);
        }
        this.seen = new boolean[n];

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                provinces++;
                dfs(i);
            }
        }

        return provinces;
    }

    private void dfs(int city) {
        seen[city] = true;

        for (int neighbour : connections.get(city)) {
            if (!seen[neighbour])
                dfs(neighbour);
        }
    }
}
