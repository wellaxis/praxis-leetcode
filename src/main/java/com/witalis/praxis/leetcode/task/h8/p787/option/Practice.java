package com.witalis.praxis.leetcode.task.h8.p787.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 787
 * Name: Cheapest Flights Within K Stops
 * URL: <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">Cheapest Flights Within K Stops</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] flights;
    private int source;
    private int destination;
    private int transplants;

    public Integer process() {
        return findCheapestPrice(number, flights, source, destination, transplants);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return -1;
    }
}
