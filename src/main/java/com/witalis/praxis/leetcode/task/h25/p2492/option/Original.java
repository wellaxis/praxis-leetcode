package com.witalis.praxis.leetcode.task.h25.p2492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ID: 2492
 * Name: Minimum Score of a Path Between Two Cities
 * URL: <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/">Minimum Score of a Path Between Two Cities</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int cities;
    private int[][] roads;

    public Integer process() {
        return minScore(cities, roads);
    }

    public int minScore(int n, int[][] roads) {
        if (n <= 0 || roads == null) return -1;

        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (final int[] road : roads) {
            map.putIfAbsent(road[0], new HashMap<>());
            map.get(road[0]).putIfAbsent(road[1], road[2]);
            map.putIfAbsent(road[1], new HashMap<>());
            map.get(road[1]).putIfAbsent(road[0], road[2]);
        }

        if (!map.containsKey(1)) return -1;

        return dfs(map, new HashSet<>(), n, 1, Integer.MAX_VALUE);
    }

    private static int dfs(Map<Integer, Map<Integer, Integer>> map, Set<Integer> seen, int cities, int city, int score) {
        if (seen.contains(city)) return score;

        seen.add(city);

        final Map<Integer, Integer> neighbours = map.get(city);
        if (neighbours != null) {
            for (Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
                Integer neighbour = entry.getKey();
                Integer distance = entry.getValue();

                score = Math.min(score, Math.min(distance, dfs(map, seen, cities, neighbour, distance)));
            }
        }

        return score;
    }
}
