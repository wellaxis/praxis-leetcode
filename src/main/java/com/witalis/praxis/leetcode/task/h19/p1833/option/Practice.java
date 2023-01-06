package com.witalis.praxis.leetcode.task.h19.p1833.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1833
 * Name: Maximum Ice Cream Bars
 * URL: <a href="https://leetcode.com/problems/maximum-ice-cream-bars/">Maximum Ice Cream Bars</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] costs;
    private int coins;

    public Integer process() {
        return maxIceCream(costs, coins);
    }

    public int maxIceCream(int[] costs, int coins) {
        if (costs == null || costs.length == 0 || coins <= 0) return 0;

        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {
            if (cost > coins) break;
            coins -= cost;
            count++;
        }

        return count;
    }
}
