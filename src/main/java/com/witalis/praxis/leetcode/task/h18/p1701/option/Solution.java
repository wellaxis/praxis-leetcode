package com.witalis.praxis.leetcode.task.h18.p1701.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1701
 * Name: Average Waiting Time
 * URL: <a href="https://leetcode.com/problems/average-waiting-time/">Average Waiting Time</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] customers;

    public Double process() {
        return averageWaitingTime(customers);
    }

    public double averageWaitingTime(int[][] customers) {
        double wait = 0;
        double curr = 0;

        for (int[] customer : customers) {
            curr = Math.max(curr, 1.0 * customer[0]) + customer[1];
            wait += curr - customer[0];
        }

        return wait / customers.length;
    }
}
