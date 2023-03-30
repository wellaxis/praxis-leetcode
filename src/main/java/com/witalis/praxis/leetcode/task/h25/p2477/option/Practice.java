package com.witalis.praxis.leetcode.task.h25.p2477.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 2477
 * Name: Minimum Fuel Cost to Report to the Capital
 * URL: <a href="https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/">Minimum Fuel Cost to Report to the Capital</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private int[][] roads;
    private int seats;

    public Practice(int[][] roads, int seats) {
        this.roads = roads;
        this.seats = seats;
    }

    public Long process() {
        return minimumFuelCost(roads, seats);
    }

    private List<Integer>[] cities;

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads == null || seats <= 0) return 0;

        final int n = roads.length + 1;
        cities = new List[n];
        IntStream.range(0, n)
            .forEach(i -> cities[i] = new ArrayList<>());
        for (final int[] road : roads) {
            cities[road[0]].add(road[1]);
            cities[road[1]].add(road[0]);
        }

        return dfs(0, 0)[0];
    }

    private long[] dfs(int source, int city) {
        if (city != 0 && cities[city].size() == 1) return new long[] {1, 1};

        final long[] path = new long[] {0, 1};
        for (final int target : cities[city]) {
            if (target == source) continue;

            final long[] targetPath = dfs(city, target);
            path[0] += targetPath[0];
            path[1] += targetPath[1];
        }
        if (city != 0) path[0] += (path[1] + seats - 1) / seats;

        return path;
    }
}
