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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] edges;
    private int source;
    private int destination;

    public Boolean process() {
        return validPath(number, edges, source, destination);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> vertices = new HashMap<>();
        for (int i = 0; i < n; i++)
            vertices.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            vertices.get(edge[0]).add(edge[1]);
            vertices.get(edge[1]).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            if (queue.peek() == destination) return true;
            int item = queue.poll();
            List<Integer> values = vertices.get(item);
            for (int value : values) {
                if (!seen[value]) {
                    queue.offer(value);
                    seen[value] = true;
                }
            }
        }

        return false;
    }
}
