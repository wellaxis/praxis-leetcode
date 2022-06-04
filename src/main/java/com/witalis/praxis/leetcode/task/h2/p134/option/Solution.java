package com.witalis.praxis.leetcode.task.h2.p134.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 134
 * Name: Gas Station
 * URL: <a href="https://leetcode.com/problems/gas-station/">Gas Station</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] gas;
    private int[] cost;

    public Integer process() {
        return canCompleteCircuit(gas, cost);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int costs = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            costs += gas[i] - cost[i];
            if (min > costs) {
                min = costs;
                index = i;
            }
        }
        return costs < 0 ? -1 : (index + 1) % gas.length;
    }
}
