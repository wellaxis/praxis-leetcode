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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<String>> tickets;

    public List<String> process() {
        return findItinerary(tickets);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();

        for (final List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs(graph, "JFK", ans);
        return ans;
    }

    private void dfs(Map<String, Queue<String>> graph, final String u, LinkedList<String> ans) {
        final Queue<String> arrivals = graph.get(u);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(graph, arrivals.poll(), ans);
        ans.addFirst(u);
    }
}
