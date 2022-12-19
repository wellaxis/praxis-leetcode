package com.witalis.praxis.leetcode.task.h20.p1971.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ID: 1971
 * Name: Find if Path Exists in Graph
 * URL: <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Find if Path Exists in Graph</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] edges;
    private int source;
    private int destination;

    public Boolean process() {
        return validPath(number, edges, source, destination);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final Map<Integer, List<Integer>> vertices = new HashMap<>();
        IntStream.range(0, n).forEach(i -> vertices.put(i, new ArrayList<>()));
        for (int[] edge : edges) {
            vertices.get(edge[0]).add(edge[1]);
            vertices.get(edge[1]).add(edge[0]);
        }

        final boolean[] seen = new boolean[n];
        final Queue<Integer> queue = new LinkedList<>(List.of(source));
        while (!queue.isEmpty()) {
            if (queue.peek() == destination) return true;

            vertices.get(queue.poll()).forEach(
                value -> {
                    if (!seen[value]) {
                        queue.offer(value);
                        seen[value] = true;
                    }
                }
            );
        }

        return false;
    }
}
