package com.witalis.praxis.leetcode.task.h8.p787.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

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

    public Practice(int number, int[][] flights, int source, int destination, int transplants) {
        this.number = number;
        this.flights = flights;
        this.source = source;
        this.destination = destination;
        this.transplants = transplants;
    }

    public Integer process() {
        return findCheapestPrice(number, flights, source, destination, transplants);
    }

    record Flight(int city, int cost) {}

    private Map<Integer, List<Flight>> directions = new HashMap<>();
    private boolean[] seen;
    private int cheapestPrice = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n <= 0 || flights == null || flights.length == 0) return -1;

        for (final int[] flight: flights) {
            directions.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new Flight(flight[1], flight[2]));
        }

        seen = new boolean[n];
        dfs(src, dst, k + 1, 0);

        return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
    }

    public void dfs(int source, int destination, int transplants, int cost) {
        if (transplants < 0 || seen[source]) return;
        if (source == destination) {
            if (cost < cheapestPrice) cheapestPrice = cost;
            return;
        }

        seen[source] = true;
        for (final Flight flight : directions.getOrDefault(source, Collections.emptyList())) {
            dfs(flight.city(), destination, transplants - 1, cost + flight.cost());
        }
        seen[source] = false;
    }
}
