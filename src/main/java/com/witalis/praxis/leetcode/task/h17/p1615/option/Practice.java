package com.witalis.praxis.leetcode.task.h17.p1615.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1615
 * Name: Maximal Network Rank
 * URL: <a href="https://leetcode.com/problems/maximal-network-rank/">Maximal Network Rank</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int cities;
    private int[][] roads;

    public Integer process() {
        return maximalNetworkRank(cities, roads);
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        if (n <= 0 || roads == null) return 0;

        final int[] degree = new int[n];
        final boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                maxRank = Math.max(maxRank, degree[i] + degree[j] - (connected[i][j] ? 1 : 0));

        return maxRank;
    }
}
