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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] days;
    private int[] costs;

    public Practice(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
    }

    public Integer process() {
        return mincostTickets(days, costs);
    }

    private int[] cache = new int[365];
    private boolean[] trips = new boolean[365];
    private int[] prices = new int[3];

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || costs == null) return 0;

        Arrays.fill(cache, -1);
        for (int day : days)
            trips[day - 1] = true;
        this.prices = costs;

        return dp(0);
    }

    private int dp(int day) {
        if (day >= 365) return 0;
        if (cache[day] >= 0) return cache[day];

        int cost;
        if (trips[day]) {
            cost = Math.min(Math.min(dp(day + 1) + prices[0], dp(day + 7) + prices[1]), dp(day + 30) + prices[2]);
        } else {
            cost = dp(day + 1);
        }
        cache[day] = cost;

        return cost;
    }
}
