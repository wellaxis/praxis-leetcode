package com.witalis.praxis.leetcode.task.h19.p1833.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1833
 * Name: Maximum Ice Cream Bars
 * URL: <a href="https://leetcode.com/problems/maximum-ice-cream-bars/">Maximum Ice Cream Bars</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] costs;
    private int coins;

    public Integer process() {
        return maxIceCream(costs, coins);
    }

    public int maxIceCream(int[] costs, int coins) {
        int icecreams = 0;

        int maxCost = costs[0];
        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] numOfCosts = new int[maxCost + 1];
        for (int cost : costs) {
            numOfCosts[cost]++;
        }

        for (int cost = 1; cost <= maxCost; ++cost) {
            if (numOfCosts[cost] == 0) continue;
            if (coins < cost) break;

            int count = Math.min(numOfCosts[cost], coins / cost);
            coins -= cost * count;
            icecreams += count;
        }

        return icecreams;
    }
}
