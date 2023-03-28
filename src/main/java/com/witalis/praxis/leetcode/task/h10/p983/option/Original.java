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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] days;
    private int[] costs;

    public Original(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
    }

    public Integer process() {
        return mincostTickets(days, costs);
    }

    private int[] cache = new int[365];
    private boolean[] trips = new boolean[365];

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || costs == null) return 0;

        Arrays.fill(cache, -1);
        for (int day : days) {
            trips[day - 1] = true;
        }

        return dp(costs, 0);
    }

    private int dp(int[] costs, int day) {
        if (day >= 365) return 0;
        if (cache[day] >= 0) return cache[day];

        int cost;
        if (trips[day]) {
            cost = Math.min(dp(costs, day + 1) + costs[0], dp(costs, day + 7) + costs[1]);
            cost = Math.min(cost, dp(costs, day + 30) + costs[2]);
        } else {
            cost = dp(costs, day + 1);
        }
        cache[day] = cost;

        return cost;
    }
}
