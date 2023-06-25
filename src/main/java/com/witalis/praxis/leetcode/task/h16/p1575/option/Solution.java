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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] locations;
    private int start;
    private int finish;
    private int fuel;

    public Integer process() {
        return countRoutes(locations, start, finish, fuel);
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);

        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) continue;

                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % 1000000007;
                    }
                }
            }
        }

        return dp[start][fuel];
    }
}
