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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int computers;
    private int[][] connections;

    public Practice(int computers, int[][] connections) {
        this.computers = computers;
        this.connections = connections;
    }

    public Integer process() {
        return makeConnected(computers, connections);
    }

    private List<Integer>[] network;
    private boolean[] seen;

    @SuppressWarnings("unchecked")
    public int makeConnected(int n, int[][] connections) {
        if (n <= 0 || connections == null) return -1;

        final int cables = connections.length;
        if (cables < n - 1) return -1;

        this.network = new List[n];
        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }
        for (final int[] connection : connections) {
            network[connection[0]].add(connection[1]);
            network[connection[1]].add(connection[0]);
        }

        this.seen = new boolean[n];

        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                counter++;
                bfs(i);
            }
        }

        return counter - 1;
    }

    private void bfs(int cable) {
        final Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(cable);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int neighbour : network[next]) {
                if (!seen[neighbour]) {
                    queue.add(neighbour);
                    seen[neighbour] = true;
                }
            }
        }
    }
}
