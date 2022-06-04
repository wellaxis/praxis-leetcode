package com.witalis.praxis.leetcode.task.h2.p134.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 134
 * Name: Gas Station
 * URL: <a href="https://leetcode.com/problems/gas-station/">Gas Station</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] gas;
    private int[] cost;

    public Integer process() {
        return canCompleteCircuit(gas, cost);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        if (gas.length != cost.length) throw new IllegalArgumentException("incorrect input data");

        int lack = 0;
        int tank = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                lack += tank;
                index = i + 1;
                tank = 0;
            }
        }

        return tank >= -lack ? index : -1;
    }
}
