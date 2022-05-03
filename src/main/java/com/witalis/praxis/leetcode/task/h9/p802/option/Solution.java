package com.witalis.praxis.leetcode.task.h9.p802.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 802
 * Name: Find Eventual Safe States
 * URL: <a href="https://leetcode.com/problems/find-eventual-safe-states/">Find Eventual Safe States</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] graph;

    public List<Integer> process() {
        return eventualSafeNodes(graph);
    }

    enum State { INIT, VISITING, VISITED }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        State[] state = new State[graph.length];

        for (int i = 0; i < graph.length; ++i)
            if (!hasCycle(graph, i, state))
                ans.add(i);

        return ans;
    }

    private boolean hasCycle(int[][] graph, int u, State[] state) {
        if (state[u] == State.VISITING) return true;
        if (state[u] == State.VISITED) return false;

        state[u] = State.VISITING;
        for (final int v : graph[u])
            if (hasCycle(graph, v, state))
                return true;
        state[u] = State.VISITED;

        return false;
    }
}
