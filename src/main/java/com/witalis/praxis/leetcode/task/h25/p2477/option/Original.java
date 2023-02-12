package com.witalis.praxis.leetcode.task.h25.p2477.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * ID: 2477
 * Name: Minimum Fuel Cost to Report to the Capital
 * URL: <a href="https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/">Minimum Fuel Cost to Report to the Capital</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] roads;
    private int seats;

    public Long process() {
        return minimumFuelCost(roads, seats);
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads == null || seats <= 0) return 0;

        int cities = roads.length + 1;

        final Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, cities)
            .forEach(i -> map.put(i, new ArrayList<>()));
        for (final int[] road : roads) {
            final int source = road[0];
            final int target = road[1];
            map.get(source).add(target);
            map.get(target).add(source);
        }

        return dfs(map, seats, 0, 0)[0];
    }

    private long[] dfs(Map<Integer, List<Integer>> map, int seats, int source, int city) {
        final long[] path = new long[] {0, 1};

        final List<Integer> targets = map.get(city);
        for (final int target : targets) {
            if (target == source) continue;

            long[] targetPath = dfs(map, seats, city, target);
            path[0] += targetPath[0];
            path[1] += targetPath[1];
        }
        if (city != 0) path[0] += Math.ceilDiv(path[1], seats);

        return path;
    }
}
