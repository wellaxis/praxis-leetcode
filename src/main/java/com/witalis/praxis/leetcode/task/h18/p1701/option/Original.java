package com.witalis.praxis.leetcode.task.h18.p1701.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1701
 * Name: Average Waiting Time
 * URL: <a href="https://leetcode.com/problems/average-waiting-time/">Average Waiting Time</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] customers;

    public Double process() {
        return averageWaitingTime(customers);
    }

    public double averageWaitingTime(int[][] customers) {
        if (customers == null || customers.length == 0) return 0;

        long waitingTime = 0;
        long currentTime = 0;
        for (int[] customer : customers) {
            currentTime = (Math.max(currentTime, customer[0]) + customer[1]);
            waitingTime += (currentTime - customer[0]);
        }

        return (double) waitingTime / customers.length;
    }
}
