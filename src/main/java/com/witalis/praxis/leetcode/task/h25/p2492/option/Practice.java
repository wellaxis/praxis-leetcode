package com.witalis.praxis.leetcode.task.h25.p2492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2492
 * Name: Minimum Score of a Path Between Two Cities
 * URL: <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/">Minimum Score of a Path Between Two Cities</a>
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
        return minScore(cities, roads);
    }

    private record Road(int city, int distance) {}

    private Map<Integer, List<Road>> map = new HashMap<>();
    private boolean[] seen;

    public int minScore(int n, int[][] roads) {
        if (n <= 0 || roads == null) return -1;

        for (int i = 1; i <= n; i++)
            map.put(i, new LinkedList<>());

        for (final int[] road : roads) {
            map.get(road[0]).add(new Road(road[1], road[2]));
            map.get(road[1]).add(new Road(road[0], road[2]));
        }

        this.seen = new boolean[n];

        return dfs(1, Integer.MAX_VALUE);
    }

    private int dfs(int city, int score) {
        if (seen[city - 1]) return score;

        seen[city - 1] = true;

        for (final Road road : map.get(city)) {
            score = Math.min(score, Math.min(road.distance(), dfs(road.city(), road.distance())));
        }

        return score;
    }
}
