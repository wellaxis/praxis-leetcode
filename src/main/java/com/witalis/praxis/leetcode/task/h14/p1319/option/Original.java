package com.witalis.praxis.leetcode.task.h14.p1319.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1319
 * Name: Number of Operations to Make Network Connected
 * URL: <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Number of Operations to Make Network Connected</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int computers;
    private int[][] connections;

    public Original(int computers, int[][] connections) {
        this.computers = computers;
        this.connections = connections;
    }

    public Integer process() {
        return makeConnected(computers, connections);
    }

    private Map<Integer, List<Integer>> network = new HashMap<>();
    private boolean[] seen;

    public int makeConnected(int n, int[][] connections) {
        if (n <= 0 || connections == null) return -1;

        final int cables = connections.length;
        if (cables < n - 1) return -1;

        for (int i = 0; i < n; i++) {
            network.put(i, new ArrayList<>());
        }
        for (final int[] connection : connections) {
            network.get(connection[0]).add(connection[1]);
            network.get(connection[1]).add(connection[0]);
        }

        this.seen = new boolean[n];

        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                counter++;
                dfs(i);
            }
        }

        return counter - 1;
    }

    private void dfs(int cable) {
        seen[cable] = true;

        final List<Integer> neighbours = network.get(cable);
        if (neighbours != null) {
            neighbours.forEach(
                neighbour -> {
                    if (!seen[neighbour]) dfs(neighbour);
                }
            );
        }
    }
}
