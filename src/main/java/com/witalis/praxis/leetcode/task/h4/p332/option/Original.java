package com.witalis.praxis.leetcode.task.h4.p332.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 332
 * Name: Reconstruct Itinerary
 * URL: <a href="https://leetcode.com/problems/reconstruct-itinerary/">Reconstruct Itinerary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<String>> tickets;

    public List<String> process() {
        return findItinerary(tickets);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) return Collections.emptyList();

        Map<String, Queue<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            flights.putIfAbsent(departure, new PriorityQueue<>(Comparator.naturalOrder()));
            flights.get(departure).offer(arrival);
        }

        List<String> itinerary = new ArrayList<>();
        dfs(flights, itinerary, "JFK");
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(Map<String, Queue<String>> flights, List<String> itinerary, String airport) {
        if (flights.containsKey(airport)) {
            while (!flights.get(airport).isEmpty()) {
                String destination = flights.get(airport).poll();
                dfs(flights, itinerary, destination);
            }
        }

        itinerary.add(airport);
    }
}
