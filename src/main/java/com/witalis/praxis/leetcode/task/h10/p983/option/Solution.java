package com.witalis.praxis.leetcode.task.h10.p983.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 983
 * Name: Minimum Cost For Tickets
 * URL: <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">Minimum Cost For Tickets</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] days;
    private int[] costs;

    public Integer process() {
        return mincostTickets(days, costs);
    }

    public int mincostTickets(int[] days, int[] costs) {
        final int n = days.length;
        final int[] pass = {1, 7, 30};
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return minCost(days, costs, pass, 0, dp);
    }

    public int minCost(int[] days, int[] costs, int[] pass, int ind, int[] dp) {
        if (ind == days.length) return 0;
        if (dp[ind] != -1) return dp[ind];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int c = costs[i];
            int d = pass[i];
            int j = ind;
            while (j < days.length && days[j] < days[ind] + d) {
                j++;
            }
            min = Math.min(min, c + minCost(days, costs, pass, j, dp));
        }

        return dp[ind] = min;
    }
}
