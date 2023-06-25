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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] locations;
    private int start;
    private int finish;
    private int fuel;

    public Practice(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        this.start = start;
        this.finish = finish;
        this.fuel = fuel;
    }

    public Integer process() {
        return countRoutes(locations, start, finish, fuel);
    }

    public static final int MOD = (int) 1e9 + 7;
    private int[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        if (locations == null || fuel <= 0) return 0;

        final int n = locations.length;
        this.dp = new int[n][fuel + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return recursiveRoutes(locations, start, finish, fuel);
    }

    private int recursiveRoutes(int[] locations, int current, int finish, int fuel) {
        if (fuel < 0) return 0;
        if (dp[current][fuel] != -1) return dp[current][fuel];

        int count = 0;
        if (current == finish) count++;
        for (int city = 0; city < locations.length; city++) {
            if (city != current) {
                int cost = fuel - Math.abs(locations[current] - locations[city]);
                count = (count % MOD + recursiveRoutes(locations, city, finish, cost) % MOD) % MOD;
            }
        }
        dp[current][fuel] = count;

        return count;
    }
}
