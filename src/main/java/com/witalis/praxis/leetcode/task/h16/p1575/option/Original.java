package com.witalis.praxis.leetcode.task.h16.p1575.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1575
 * Name: Count All Possible Routes
 * URL: <a href="https://leetcode.com/problems/count-all-possible-routes/">Count All Possible Routes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] locations;
    private int start;
    private int finish;
    private int fuel;

    public Integer process() {
        return countRoutes(locations, start, finish, fuel);
    }

    public static final int MOD = 1_000_000_007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        if (locations == null || fuel <= 0) return 0;

        final int n = locations.length;
        final int[][] dp = new int[n][fuel + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return recursiveRoutes(locations, start, finish, fuel, dp);
    }

    private int recursiveRoutes(int[] locations, int current, int finish, int fuel, int[][] dp) {
        if (fuel < 0) return 0;
        if (dp[current][fuel] != -1) return dp[current][fuel];

        int count = 0;
        if (current == finish) count++;
        for (int city = 0; city < locations.length; city++) {
            if (city != current) {
                int cost = fuel - Math.abs(locations[current] - locations[city]);
                count = (count % MOD + recursiveRoutes(locations, city, finish, cost, dp) % MOD) % MOD;
            }
        }
        dp[current][fuel] = count % MOD;

        return dp[current][fuel];
    }
}
