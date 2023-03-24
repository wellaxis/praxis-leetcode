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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int cities;
    private int[][] roads;

    public Original(int cities, int[][] roads) {
        this.cities = cities;
        this.roads = roads;
    }

    public Integer process() {
        return minReorder(cities, roads);
    }

    private Map<Integer, List<Integer>> forward = new HashMap<>();
    private Map<Integer, List<Integer>> backward = new HashMap<>();

    public int minReorder(int n, int[][] connections) {
        if (n <= 0 || connections == null || connections.length != n - 1) return -1;

        for (int i = 0; i < n; i++) {
            forward.put(i, new ArrayList<>());
            backward.put(i, new ArrayList<>());
        }
        for (final int[] connection : connections) {
            forward.get(connection[0]).add(connection[1]);
            backward.get(connection[1]).add(connection[0]);
        }

        return dfs(0, -1, 0);
    }

    private int dfs(int city, int parent, int reorders) {
        // forward
        for (int neighbour : forward.get(city)) {
            if (neighbour != parent) reorders += dfs(neighbour, city, 1);
        }
        // backward
        for (int neighbour : backward.get(city)) {
            if (neighbour != parent) reorders += dfs(neighbour, city, 0);
        }

        return reorders;
    }
}
