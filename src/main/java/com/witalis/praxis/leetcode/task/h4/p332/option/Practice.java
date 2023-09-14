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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<String>> tickets;

    public Practice(List<List<String>> tickets) {
        this.tickets = tickets;
    }

    public List<String> process() {
        return findItinerary(tickets);
    }

    private Map<String, Queue<String>> flights = new HashMap<>();
    private List<String> itinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) return Collections.emptyList();

        for (List<String> ticket : tickets) {
            final String departure = ticket.get(0);
            final String arrival = ticket.get(1);

            flights.computeIfAbsent(departure, d -> new PriorityQueue<>(Comparator.naturalOrder())).offer(arrival);
        }

        dfs("JFK");
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport) {
        while (flights.containsKey(airport) && !flights.get(airport).isEmpty()) {
            final String destination = flights.get(airport).poll();

            dfs(destination);
        }

        itinerary.add(airport);
    }
}
