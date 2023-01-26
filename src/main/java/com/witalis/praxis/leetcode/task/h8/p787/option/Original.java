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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] flights;
    private int source;
    private int destination;
    private int transplants;

    public Integer process() {
        return findCheapestPrice(number, flights, source, destination, transplants);
    }

    record Flight(int city, int cost) {}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n <= 0 || flights == null || flights.length == 0) return -1;

        Map<Integer, List<Flight>> directions = new HashMap<>();
        for (int[] flight: flights) {
            directions.putIfAbsent(flight[0], new ArrayList<>());
            directions.get(flight[0]).add(new Flight(flight[1], flight[2]));
        }

        int[] cheapestPrice = {-1};
        dfs(directions, cheapestPrice, new boolean[n], src, dst, k + 1, 0);

        return cheapestPrice[0];
    }

    public void dfs(Map<Integer, List<Flight>> directions, int[] cheapestPrice, boolean[] seen, int source, int destination, int transplants, int cost) {
        if (transplants < 0) return;
        if (seen[source]) return;
        if (source == destination) {
            cheapestPrice[0] = cheapestPrice[0] == -1 ? cost : Math.min(cheapestPrice[0], cost);
            return;
        }

        seen[source] = true;

        List<Flight> flights = directions.get(source);
        if (flights != null) {
            for (Flight flight : flights) {
                dfs(directions, cheapestPrice, seen, flight.city(), destination, transplants - 1, cost + flight.cost());
            }
        }

        seen[source] = false;
    }
}
