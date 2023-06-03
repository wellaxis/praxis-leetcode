package com.witalis.praxis.leetcode.task.h14.p1376.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1376
 * Name: Time Needed to Inform All Employees
 * URL: <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Time Needed to Inform All Employees</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int employees;
    private int headIdentifier;
    private int[] managers;
    private int[] informTimes;

    public Integer process() {
        return numOfMinutes(employees, headIdentifier, managers, informTimes);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int solve = 0;

        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            int time = 0;
            int node = i;
            while (node != headID) {
                if (cache[node] > 0) {
                    time += cache[node];
                    break;
                }
                time += informTime[manager[node]];
                node = manager[node];
            }
            cache[i] = time;
            solve = Math.max(solve, time);
        }

        return solve;
    }
}
