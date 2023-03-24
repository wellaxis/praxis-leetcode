package com.witalis.praxis.leetcode.task.h15.p1466.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1466
 * Name: Reorder Routes to Make All Paths Lead to the City Zero
 * URL: <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">Reorder Routes to Make All Paths Lead to the City Zero</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int cities;
    private int[][] roads;

    public Practice(int cities, int[][] roads) {
        this.cities = cities;
        this.roads = roads;
    }

    public Integer process() {
        return minReorder(cities, roads);
    }

    private Map<Integer, List<int[]>> map = new HashMap<>();
    private boolean[] seen;

    public int minReorder(int n, int[][] connections) {
        if (n <= 0 || connections == null || connections.length != n - 1) return -1;

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (final int[] connection : connections) {
            map.get(connection[0]).add(new int[] {connection[1], 1});
            map.get(connection[1]).add(new int[] {connection[0], 0});
        }

        this.seen = new boolean[n];
        seen[0] = true;

        return dfs(0);
    }

    private int dfs(int city) {
        int reorders = 0;

        for (final int[] neighbours : map.get(city)) {
            if (!seen[neighbours[0]]) {
                seen[neighbours[0]] = true;
                if (neighbours[1] == 1) reorders++;

                reorders += dfs(neighbours[0]);
            }
        }

        return reorders;
    }
}
